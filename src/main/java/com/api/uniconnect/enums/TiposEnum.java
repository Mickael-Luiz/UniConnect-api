package com.api.uniconnect.enums;

public class TiposEnum {

    public enum TipoUsuario {
        PJ,
        PF

//        public static TipoUsuario fromString(String valor) {
//            if(valor == null) {
//                throw new IllegalArgumentException("Tipo usuário não pode ser nulo");
//            }
//            try {
//                return TipoUsuario.valueOf(valor.trim().toUpperCase());
//            } catch (IllegalArgumentException e) {
//                throw new IllegalArgumentException("Tipo usuário inválido");
//            }
//        }
    }
}
