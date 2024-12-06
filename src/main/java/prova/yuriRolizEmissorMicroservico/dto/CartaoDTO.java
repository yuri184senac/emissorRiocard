package prova.yuriRolizEmissorMicroservico.dto;

import java.io.Serializable;

public class CartaoDTO implements Serializable {
    private Long id;
    private String cpf;
    private Long saldo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Long getSaldo() {
        return saldo;
    }

    public void setSaldo(Long saldo) {
        this.saldo = saldo;
    }
}
