package com.examplesimpleshop.ecommerce.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;
public record OrderRequest(@NotBlank @Size(min=10) String shippingAddress,@NotEmpty List<@Valid OrderItemRequest> items) {}
