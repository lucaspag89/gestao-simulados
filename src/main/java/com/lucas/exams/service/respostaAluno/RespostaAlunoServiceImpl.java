package com.lucas.exams.service.respostaAluno;

import com.lucas.exams.dto.resposta.RespostaAlunoDTO;
import com.lucas.exams.model.*;
import com.lucas.exams.model.questao.Questao;
import com.lucas.exams.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Service;

@Service
public class RespostaAlunoServiceImpl implements RespostaAlunoService {

    @Autowired
    RespostaAlunoRepository respostaAlunoRepository;

    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    SimuladoRepository simuladoRepository;

    @Autowired
    ProvaRepository provaRepository;

    @Autowired
    QuestaoRepository questaoRepository;

    @Autowired
    AlternativaRepository alternativaRepository;

    @Override
    public RespostaAluno createResposta(RespostaAlunoDTO respostaAlunoDTO) {

        Aluno aluno = alunoRepository.findFirstById(respostaAlunoDTO.getAlunoId());
        Simulado simulado = simuladoRepository.findFirstById(respostaAlunoDTO.getSimuladoId());
        Prova prova = provaRepository.findFirstById(respostaAlunoDTO.getProvaId());
        Questao questao = questaoRepository.findFirstById(respostaAlunoDTO.getQuestaoId());
        Alternativa alternativa = alternativaRepository.findFirstById(respostaAlunoDTO.getAlternativaId());

        RespostaAluno resposta =
                new RespostaAluno().fromRespostaAlunoDTO(aluno, simulado, prova, questao, alternativa);

        respostaAlunoRepository.save(resposta);

        return resposta;
    }
}
