package com.example.LABMedical_API.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "perfis")
public class PerfilEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long perfilId;
    //TODO: implementar de GrantedAuthority e criar atributos
}
