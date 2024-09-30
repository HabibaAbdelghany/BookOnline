package com.bookOline.bookOline.entity;


import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data

public class BookOrderId  implements Serializable {

    private Integer bookId;
    private Integer orderId;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookOrderId that)) return false;
        return Objects.equals(getBookId(), that.getBookId()) &&
                Objects.equals(getOrderId(), that.getOrderId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBookId(), getOrderId());
    }
}