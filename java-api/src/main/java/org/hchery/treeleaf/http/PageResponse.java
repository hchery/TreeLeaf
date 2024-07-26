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
public abstract class PageResponse implements ApiResponse {
    @Serial
    private static final long serialVersionUID = 6615933931828130898L;

    private int dataTotal;
    private int pageTotal;
    private int pageIndex;
    private int pageSize;
}
