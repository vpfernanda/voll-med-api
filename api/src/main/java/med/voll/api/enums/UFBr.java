package med.voll.api.enums;

public enum UFBr {
    AC("Acre"),
    AL("Alagoas"),
    AM("Amazonas"),
    AP("Amapá"),
    BA("Bahia"),
    CE("Ceará"),
    DF("Distrito Federal"),
    ES("Espírito Santo"),
    GO("Goiás"),
    MA("Maranhão"),
    MG("Minas Gerais"),
    MS("Mato Grosso do Sul"),
    MT("Mato Grosso"),
    PA("Pará"),
    PB("Paraíba"),
    PE("Pernambuco"),
    PI("Piauí"),
    PR("Paraná"),
    RJ("Rio de Janeiro"),
    RN("Rio Grande do Norte"),
    RO("Rondônia"),
    RR("Roraima"),
    RS("Rio Grande do Sul"),
    SC("Santa Catarina"),
    SE("Sergipe"),
    SP("São Paulo"),
    TO("Tocantins");

    private final String nome;

    // Construtor que recebe o nome da UF
    UFBr(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public static UFBr fromSigla(String sigla) {
        for (UFBr uf : UFBr.values()) {
            if (uf.name().equals(sigla)) {
                return uf;
            }
        }
        throw new IllegalArgumentException("UF não encontrada para a sigla: " + sigla);
    }

}
