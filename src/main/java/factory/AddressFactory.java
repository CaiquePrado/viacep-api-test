package factory;

import dto.Address;

public interface AddressFactory {

    static Address validCepResponse() {
        return Address.builder()
        .cep("01001-000")
        .logradouro("Praça da Sé")
        .complemento("lado ímpar")
        .unidade("")
        .bairro("Sé")
        .localidade("São Paulo")
        .uf("SP")
        .estado("São Paulo")
        .regiao("Sudeste")
        .ibge("3550308")
        .gia("1004")
        .ddd("11")
        .siafi("7107")
        .build();
    }

    static Address validCepByAddressResponse() {
        return Address.builder()
        .cep("45003-210")
        .logradouro("Rua das Pedrinhas")
        .complemento("")
        .unidade("")
        .bairro("Cruzeiro")
        .localidade("Vitória da Conquista")
        .uf("BA")
        .estado("Bahia")
        .regiao("Nordeste")
        .ibge("2933307")
        .gia("")
        .ddd("77")
        .siafi("3965")
        .build();
    }
}
