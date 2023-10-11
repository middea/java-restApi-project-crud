package kz.yerbolov.restApiSeptember.entities;

import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemDTO {
    private Long id;
    private String name;
    private int price;
    private int amount;
    private List<Category>categories;
}
