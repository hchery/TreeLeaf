/**
 * DATE: 2024/6/4
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
import {SeedToken} from "antd/es/theme/interface";
import {MapToken} from "antd/lib/theme/interface";
import {CustomToken} from "antd-style";
import {theme} from "antd";

export const makeDarkTheme = (seedToken: SeedToken, mapToken?: MapToken): CustomToken => ({
  ...theme.darkAlgorithm(seedToken, mapToken),
  colorBgLayout: "rgb(40, 40, 40)"
})
