package com.psp.fd.pspspringboot.mockitoJwt.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewDto {
    private int id;
    private String title;
    private String content;
    private int stars;
}
