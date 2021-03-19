package com.lucas.exams.service.simulado;

import com.lucas.exams.dto.simulado.RankingDTO;
import com.lucas.exams.model.*;
import com.lucas.exams.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RankingAlunosServiceImpl implements RankingAlunosService {

    @Autowired
    SimuladoRepository simuladoRepository;

    @Autowired
    RespostaAlunoRepository respostaAlunoRepository;

    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    ValorQuestaoRepository valorQuestaoRepository;

    @Override
    public List<RankingDTO> getSimuladoRanking(Long id) {

        List<RankingDTO> simuladoRanking;

        List<Simulado> gabaritoList;
        gabaritoList = simuladoRepository.findAllBySimuladoId(id);
        List<RespostaAluno> respostaList = respostaAlunoRepository.findAllJoinQuestaoJoinRespostaAluno();
        List<Aluno> alunoList = alunoRepository.findAll();

        List<RankingDTO> notasList = getNotas(gabaritoList, respostaList, alunoList);

        if (notasList != null) {
            simuladoRanking = getRanking(notasList);

            return simuladoRanking;
        }

        return null;
    }

    private List<RankingDTO> getNotas(
            List<Simulado> gabaritoList, List<RespostaAluno> respostaList, List<Aluno> alunoList) {
        List<RankingDTO> rankingDTOList = new ArrayList<>();

        if (respostaList.size() > 0 && gabaritoList.size() > 0 && alunoList.size() > 0) {
            Map<Long, Simulado> mapGabarito = gabaritoList.stream()
                    .collect(Collectors.toMap(Simulado::getId, simulado -> simulado));

            List<RespostaAluno> respostasCorretas = new ArrayList<>();

            respostaList.forEach(resposta -> {
                if (mapGabarito.containsKey(resposta.getAlternativa().getId())) {
                    respostasCorretas.add(resposta);
                }
            });

            alunoList.forEach(aluno -> {
                List<RespostaAluno> result = respostasCorretas.stream()
                        .filter(r -> r.getAluno().getId().equals(aluno.getId()))
                        .collect(Collectors.toList());

                List<RespostaAluno> facil = result.stream()
                        .filter(f -> "facil".equalsIgnoreCase(f.getQuestao().getNivel().toString()))
                        .collect(Collectors.toList());

                Long Qf = (long) facil.size();

                List<RespostaAluno> medio = result.stream()
                        .filter(f -> "medio".equalsIgnoreCase(f.getQuestao().getNivel().toString()))
                        .collect(Collectors.toList());

                Long Qm = (long) medio.size();

                List<RespostaAluno> dificil = result.stream()
                        .filter(f -> "dificil".equalsIgnoreCase(f.getQuestao().getNivel().toString()))
                        .collect(Collectors.toList());

                Long Qd = (long) dificil.size();

                ValorQuestao valor = valorQuestaoRepository.getFirstById(1L);
                Long NS = ((Qf * valor.getFacil()) + (Qm * valor.getMedio()) + (Qd * valor.getDificil()) + valor.getFator());

                rankingDTOList.add(new RankingDTO().fromRanking(aluno, NS));

            });

            return rankingDTOList;
        }

        return null;
    }

    private List<RankingDTO> getRanking(List<RankingDTO> rankingDTOList) {
        List<RankingDTO> ranking;
        ranking = rankingDTOList.stream()
                .sorted(Comparator.comparingLong(RankingDTO::getNota).reversed())
                .limit(5)
                .collect(Collectors.toList());

        for (int i = 0; i < ranking.size(); i++) {
            ranking.get(i).setPosicao((long) i + 1);
            Long first = ranking.get(i).getNota();
            if (i >= 1) {
                Long second = ranking.get(i - 1).getNota();
                if (first.equals(second)) {
                    ranking.get(i).setPosicao(ranking.get(i - 1).getPosicao());
                }
            }
        }

        return ranking;
    }
}
