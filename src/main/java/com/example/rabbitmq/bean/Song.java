package com.example.rabbitmq.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Song implements Serializable {

    private String songName;
    private String author;
    private String lyric;


}
