package org.hchery.treeleaf;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * DATE: 2024/5/13
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@AllArgsConstructor
@Data
public class HttpBody implements Serializable {
    @Serial
    private static final long serialVersionUID = -9050181129051804959L;

    private final int code;
    private final String desc;
    private final Object data;
    private final Date time = new Date();

    public HttpBody(Object data) {
        this(0, "OK", data);
    }

    public HttpBody() {
        this(null);
    }

    public HttpBody(int code, String desc) {
        this(code, desc, null);
    }
}
