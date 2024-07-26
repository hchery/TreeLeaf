package org.hchery.treeleaf.http;

import lombok.Data;

import java.io.Serial;

/**
 * DATE: 2024/5/14
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@Data
public abstract class PageRequest implements ApiRequest {
    @Serial
    private static final long serialVersionUID = 8745125012341630381L;

    private int pageIndex;
    private int pageSize;
}
