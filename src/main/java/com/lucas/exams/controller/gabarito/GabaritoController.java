package com.lucas.exams.controller.gabarito;

import com.lucas.exams.dto.gabarito.GabaritoProvaDTO;
import com.lucas.exams.service.gabarito.GabaritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/gabaritos")
public class GabaritoController {

    @Autowired
    GabaritoService gabaritoService;

    @GetMapping("/{id}")
    public ResponseEntity<GabaritoProvaDTO> findByProvaId(@PathVariable("id") Long id) {

        try {

            GabaritoProvaDTO gabarito = gabaritoService.findByProvaId(id);

            if (gabarito != null) {
                return new ResponseEntity<>(gabarito, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(gabarito, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
