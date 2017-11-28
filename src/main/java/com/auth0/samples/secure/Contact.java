package com.auth0.samples.secure;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
class Contact {
    private String name;
    private String phone;
}
