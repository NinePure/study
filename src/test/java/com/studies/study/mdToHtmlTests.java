package com.studies.study;

import com.studies.study.utils.MdToHtml;
import java.io.File;
import java.io.FileFilter;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * detail
 *
 * @author gujiashun
 * @date 2020/5/25
 */
@SpringBootTest
public class mdToHtmlTests {

    @Test
    public void testMdUtil() {
        File file = new File("F:\\gjs\\极客时间\\数据结构与算法之美");
        if (file.isDirectory()) {
            File[] files = file.listFiles(pathname -> pathname.getName().endsWith(".md"));
            for (File mdFile : files) {
                MdToHtml.mdConvert2Html(mdFile);
            }
        }
    }

}
