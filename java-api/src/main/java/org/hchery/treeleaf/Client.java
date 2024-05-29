package org.hchery.treeleaf;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * DATE: 2024/5/15
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@Data
public class Client implements Serializable {
    @Serial
    private static final long serialVersionUID = 358107009023228438L;

    private String remoteIp;
    private String userAgent;
}
