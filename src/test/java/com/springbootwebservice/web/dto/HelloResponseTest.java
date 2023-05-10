package com.springbootwebservice.web.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class HelloResponseTest {
    @DisplayName("롬복_기능_테스트")
    @Test
    void lombokTest() {
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponse dto = new HelloResponse(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
