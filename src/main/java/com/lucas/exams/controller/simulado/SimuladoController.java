package com.lucas.exams.controller.simulado;

import com.lucas.exams.dto.simulado.RankingDTO;
import com.lucas.exams.dto.simulado.SimuladoDTO;
import com.lucas.exams.model.Simulado;
import com.lucas.exams.service.simulado.RankingAlunosService;
import com.lucas.exams.service.simulado.SimuladoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/simulados")
public class SimuladoController {

    @Autowired
    SimuladoService simuladoService;

    @Autowired
    RankingAlunosService rankingAlunosService;

    @GetMapping()
    public ResponseEntity<List<SimuladoDTO>> findAllByQuestionId() {

        try {
            List<SimuladoDTO> simulados = simuladoService.findAllSimulados();

            return new ResponseEntity<>(simulados, HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{id}/rankings")
    public ResponseEntity<List<RankingDTO>> getRankingAlunos(@PathVariable("id") Long id) {

        List<RankingDTO> ranking;

        try {
            ranking = rankingAlunosService.getSimuladoRanking(id);

            return new ResponseEntity<>(ranking, HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
