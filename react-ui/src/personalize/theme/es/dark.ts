/**
 * DATE: 2024/6/1
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */

import {MappingAlgorithm, theme, ThemeConfig} from "antd";
import {styleToken} from "@/personalize/theme/style-var";
import {AppToken} from "@/personalize/theme";

const darkToken: AppToken = {
}

const darkAlgorithm: MappingAlgorithm = (sk, mk) => ({
  ...theme.darkAlgorithm(sk, mk),
  ...darkToken,
  ...styleToken
})

const darkTheme: ThemeConfig = {
  algorithm: darkAlgorithm
}

export default darkTheme
