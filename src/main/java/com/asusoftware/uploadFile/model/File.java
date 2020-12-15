package com.asusoftware.uploadFile.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "data")
public class File {

    @Id
    @GeneratedValue
    private UUID id;

    @NotNull
    private String path;
}
