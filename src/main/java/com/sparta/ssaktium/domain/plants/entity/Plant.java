package com.sparta.ssaktium.domain.plants.entity;

import com.sparta.ssaktium.domain.common.entity.Timestamped;
import com.sparta.ssaktium.domain.plants.dto.requestDto.PlantCreateRequestDto;
import com.sparta.ssaktium.domain.users.entity.Users;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Plant extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users userId;

    private String plantName;

    private String plantNickname;

    private String imageUrl;

    public Plant(PlantCreateRequestDto requestDto, Users userId, String imageUrl) {
        this.userId = userId;
        this.plantName = requestDto.getPlantName();
        this.plantNickname = requestDto.getPlantNickname();
        this.imageUrl = imageUrl;
    }

    public void update(PlantCreateRequestDto requestDto) {
        this.plantName = requestDto.getPlantName();
        this.plantNickname = requestDto.getPlantNickname();
        this.imageUrl = requestDto.getImageUrl();
    }
}