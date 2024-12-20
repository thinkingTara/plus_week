package com.example.demo.entity;

import lombok.Getter;

@Getter
public enum ReservationStatus {

    PENDING("PENDING 상태만 APPROVED , EXPIRED 로 변경 가능합니다."),
    APPROVED("APPROVED 되었습니다."),
    CANCELED("CANCELED 되었습니다"),
    EXPIRED("EXPIRED 상태인 예약은 취소할 수 없습니다.");

    private final String statusMessage;
    ReservationStatus(String statusMessage) {
        this.statusMessage = statusMessage;
    }


}
