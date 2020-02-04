package com.fr.ojt.batch.model;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
public class Order implements Serializable {
    private static final long serialVersionUID = -4908977156333631639L;

    /**
     * order ID
     */
    @NotNull
    private Long orderId;

    /**
     * name
     */
    private String name;

    /**
     * order quantity
     */
    private int quantity;

    /**
     * unit price of the item
     */
    private BigDecimal unitPrice;

    /**
     * sub total
     */
    private BigDecimal subTotal;

    /**
     * shipping fee
     */
    private BigDecimal shippingFee;

    /**
     * item total
     */
    private BigDecimal itemTotal;

    /**
     * grand total
     */
    private BigDecimal grandTotal;

    /**
     * order date time
     */
    private OffsetDateTime dateTime;

    /**
     * client ID
     */
    private String clientId;

    /**
     * customer id
     */
    private Long customerId;

}

