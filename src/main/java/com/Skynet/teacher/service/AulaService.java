package com.Skynet.teacher.service;

import java.util.List;

import com.Skynet.teacher.entities.Aula;
import com.Skynet.teacher.repository.AulaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AulaService {

    @Autowired
    private AulaRepository aulaRepository;

    @Autowired
    private AlunoService alunoService;

    public List<Aula> listarAulasTurmaDisciplina(long turmaDisciplinaId) {
        List<Aula> aulas = aulaRepository.encontrarAulaPelaDisciplinaTurma(turmaDisciplinaId);

        if (aulas.isEmpty()) {
            return null;
        }
        return aulas;
    }

    public ObjectNode listarQuantidadePresencaAlunoDisciplina(long turmaDisciplinaId, long alunoId) {
        ObjectMapper objMapper = new ObjectMapper();
        ObjectNode objNode = objMapper.createObjectNode();
        try {
            List<Aula> aulas = aulaRepository.encontrarAulaPelaDisciplinaTurma(turmaDisciplinaId);
            int aulasTotais = aulas.size();
            int aulasPresente = 0;

            for (Aula aula : alunoService.findAlunoById(alunoId).getAulas()) {
                if (aulas.contains(aula)) {
                    aulasPresente++;
                }
            }

            objNode.put("aulasTotais", aulasTotais);
            objNode.put("presentes", aulasPresente);
            objNode.put("ausentes", (aulasTotais - aulasPresente));

            return objNode;

        } catch (Exception e) {
            throw e;
        }
    }

    public Aula aulaById(Long aulaId) {
        try {
            Aula aulaExistente = aulaRepository.findById(aulaId).orElse(null);
            return aulaExistente;

        } catch (Exception e) {
            return new Aula();
        }
    }

    public Aula insertAula(Aula aula) {
        return aulaRepository.save(aula);
    }

    public Boolean alterarAula(Long id) {
        try {
            aulaRepository.aulaOcorrida(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean aulaPreviamenteCadastrada(Long id, String data) {
        try {
            List<Aula> aula = aulaRepository.aulaPreviamenteCadastrada(id, data);
            if (aula != null && aula.size()>0) {
                return true;
            }
            return false;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

}
