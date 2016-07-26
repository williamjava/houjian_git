package com.tu.test;

import java.lang.annotation.Repeatable;

@Repeatable(Authorities.class)
public @interface Authority {
     String role();
}

