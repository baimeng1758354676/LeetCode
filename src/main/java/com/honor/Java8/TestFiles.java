package com.honor.Java8;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * @Description
 * @Author baimeng
 * @Date 2021/9/2 14:41
 **/
public class TestFiles {
    public static void main(String[] args) {

        Path path = FileSystems.getDefault().getPath("D:\\hydee\\返利平台\\sql整理");
        try {
            Stream<Path> list = Files.list(path);
            list.filter(p -> !Files.isDirectory(p)).forEach(t -> {
                try {
                    Files.lines(t).filter(s -> s.startsWith("TRUNCATE")).forEach(s -> {

                        System.out.println(String.format("文件名：%s, 路径：%s, 内容：%s", t.getFileName(), t, s));

                    });

                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
