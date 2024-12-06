package prova.yuriRolizEmissorMicroservico.controllers;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prova.yuriRolizEmissorMicroservico.dto.CartaoDTO;

@RestController
@RequestMapping("cartao")
public class CartaoController {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @PutMapping("/atualizar")
    @CrossOrigin(origins = "*")
    public ResponseEntity<CartaoDTO> atualizarCartao(@RequestBody CartaoDTO cartaoDTO) {
        rabbitTemplate.convertAndSend("direct-exchange-default", "queue-a-key", cartaoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(cartaoDTO);
    }

}
