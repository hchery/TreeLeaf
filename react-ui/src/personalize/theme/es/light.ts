/**
 * DATE: 2024/6/1
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
import {MappingAlgorithm, theme, ThemeConfig} from "antd";
import {styleToken} from "@/personalize/theme/style-var";
import {AppToken} from "@/personalize/theme";

const lightToken: AppToken = {
}

const lightAlgorithm: MappingAlgorithm = (sk) => ({
  ...theme.defaultAlgorithm(sk),
  ...lightToken,
  ...styleToken,
})

const lightTheme: ThemeConfig = {
  algorithm: lightAlgorithm
}

export default lightTheme
