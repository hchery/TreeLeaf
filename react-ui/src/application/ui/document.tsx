/**
 * DATE: 2024/6/5
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
import {RC} from "@/components/reactor";
import {PropsWithChildren, useEffect} from "react";

export const ApplicationName = "TreeLeaf"

type TitleSlot = PropsWithChildren<{title: string}>

export const DocumentTitle = RC(({title, children}: TitleSlot) => {
  useEffect(() => {
    document.title = `${title} - ${ApplicationName}`
  }, [title]);
  return (<>{children}</>)
})
