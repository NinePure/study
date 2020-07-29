package com.studies.study.controller;

import com.studies.study.utils.JaxbXmlUtil;
import com.studies.study.vo.JxjsResponseVO;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 测试对外接口
 *
 * @author gujiashun
 * @date 2020/4/27
 */
@RequestMapping
@Controller
public class TestDwjkController {

    @PostMapping("/sss")
    public void getDetail(HttpServletRequest request, HttpServletResponse response){
        StringBuilder result = new StringBuilder();
        String responseStr = "";
        try (
                InputStream inputStream = request.getInputStream();
                OutputStream outputStream = response.getOutputStream()
                ) {
            List<String> strings = IOUtils.readLines(inputStream, StandardCharsets.UTF_8);
            for (String string : strings) {
                result.append(string).append(IOUtils.LINE_SEPARATOR_WINDOWS);
            }
            responseStr = JaxbXmlUtil.entity2Xml(new JxjsResponseVO());
//            responseStr = JaxbXmlUtil.entity2Xml(new JxjsResponseVO("123"));
            IOUtils.write(responseStr.getBytes(StandardCharsets.UTF_8),outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(result);
        System.out.println(responseStr);
    }

    /**
     * 原审案件
     * @param drspTicket
     * @param startPage
     * @param pageSize
     * @param ah
     * @return
     * @throws UnsupportedEncodingException
     */
    @GetMapping("/ysaj")
    @ResponseBody
    public String getDetail(@RequestParam("drsp_ticket")String drspTicket,
            @RequestParam("startPage")Integer startPage,
            @RequestParam("pageSize")Integer pageSize,
            @RequestParam("c_ah")String ah) throws UnsupportedEncodingException {
        String decodeAh = URLDecoder.decode(ah, StandardCharsets.UTF_8.toString());
        String decodedrspTicket = URLDecoder.decode(drspTicket, StandardCharsets.UTF_8.toString());
        if ("12345678Aa"
                .equals(decodeAh)) {
            return "<resource xmlns=\"http://dataexchange.court.gov.cn/2009/data\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n"
                    + "<brief>\n"
                    + "<count>0</count>\n"
                    + "</brief>\n"
                    + "</resource>";
        }
        String string = "<resource xmlns=\"http://dataexchange.court.gov.cn/2009/data\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n"
                + "<brief>\n"
                + "<count>1</count>\n"
                + "</brief>\n"
                + "\t<data>\n"
                + "\t\t<T_AJ_AJXQ>\n"
                + "\t\t\t<DT_LASJ>2014-12-31 00:00:00.0</DT_LASJ>\n"
                + "\t\t\t<N_AJBS>401600000047600</N_AJBS>\n"
                + "\t\t\t<C_AJSJ/>\n"
                + "\t\t\t<C_GSHAH>2015青民初89</C_GSHAH>\n"
                + "\t\t\t<N_AJLB>30000</N_AJLB>\n"
                + "\t\t\t<N_AJJZJD>7</N_AJJZJD>\n"
                + "\t\t\t<N_SYCX>2</N_SYCX>\n"
                + "\t\t\t<DT_JASJ>2015-02-09 00:00:00.0</DT_JASJ>\n"
                + "\t\t\t<N_LAAY>9143</N_LAAY>\n"
                + "\t\t\t<DT_ZHGXSJ/>\n"
                + "\t\t\t<N_BH_CBR>263192854</N_BH_CBR>\n"
                + "\t\t\t<N_MC_CBR>承办人</N_MC_CBR>\n"
                + "\t\t\t<N_SALY/>\n"
                + "\t\t\t<C_LAAY>9143</C_LAAY>\n"
                + "\t\t\t<N_BH_JBFY>4016</N_BH_JBFY>\n"
                + "\t\t\t<N_SPCX>审判程序</N_SPCX>\n"
                + "\t\t\t<N_JAFS>1</N_JAFS>\n"
                + "\t\t\t<N_JAAY>9143</N_JAAY>\n"
                + "\t\t\t<N_BH_LAR/>\n"
                + "\t\t\t<C_AJMC/>\n"
                + "\t\t\t<C_AH>(2015)青民初字第89号</C_AH>\n"
                + "\t\t\t<N_AJZLB>30100</N_AJZLB>\n"
                + "\t\t\t<C_JAAY>9143</C_JAAY>\n"
                + "\t\t\t<C_BH>242a52e09eb52083e11a59a60e4d4274</C_BH>\n"
                + "\t\t\t<T_AJ_DSR_AJXQ>\n"
                + "\t\t\t\t<C_QTSFZJMC/>\n"
                + "\t\t\t\t<N_LX>2</N_LX>\n"
                + "\t\t\t\t<C_MC>青铜峡市恒源冶炼有限责任公司</C_MC>\n"
                + "\t\t\t\t<N_SFZJLX/>\n"
                + "\t\t\t\t<N_ZZMM/>\n"
                + "\t\t\t\t<N_XWNL/>\n"
                + "\t\t\t\t<N_XB/>\n"
                + "\t\t\t\t<C_DSRAJDW>2</C_DSRAJDW>\n"
                + "\t\t\t\t<C_BH_AJ>242a52e09eb52083e11a59a60e4d4274</C_BH_AJ>\n"
                + "\t\t\t\t<C_HJD/>\n"
                + "\t\t\t\t<C_XZZ>青铜峡市新材料基地</C_XZZ>\n"
                + "\t\t\t\t<N_GZDWXZ/>\n"
                + "\t\t\t\t<C_ZJHM/>\n"
                + "\t\t\t\t<N_WHCD/>\n"
                + "\t\t\t\t<C_GZDWMC/>\n"
                + "\t\t\t\t<N_MZ/>\n"
                + "\t\t\t\t<N_FDMSAJDW/>\n"
                + "\t\t\t\t<N_XH>4</N_XH>\n"
                + "\t\t\t\t<C_TSSF/>\n"
                + "\t\t\t\t<N_HJSZD>0</N_HJSZD>\n"
                + "\t\t\t\t<C_FDDBR/>\n"
                + "\t\t\t\t<N_SF/>\n"
                + "\t\t\t\t<C_TSSLHBL/>\n"
                + "\t\t\t\t<N_HYZK/>\n"
                + "\t\t\t\t<D_CSRQ/>\n"
                + "\t\t\t\t<C_ZYBSJGSZD/>\n"
                + "\t\t\t\t<N_ZCDGJDQ>156</N_ZCDGJDQ>\n"
                + "\t\t\t\t<N_GZDWLX/>\n"
                + "\t\t\t\t<C_SJHM/>\n"
                + "\t\t\t\t<C_DZYX/>\n"
                + "\t\t\t\t<N_JCJZD/>\n"
                + "\t\t\t\t<N_GJ/>\n"
                + "\t\t\t\t<C_QTLXDH/>\n"
                + "\t\t\t\t<C_BH>eee0266b945ec0c1b592e15626bc7d32</C_BH>\n"
                + "\t\t\t</T_AJ_DSR_AJXQ>\n"
                + "\t\t\t<T_AJ_DSR_AJXQ>\n"
                + "\t\t\t\t<C_QTSFZJMC/>\n"
                + "\t\t\t\t<N_LX>1</N_LX>\n"
                + "\t\t\t\t<C_MC>丁吉忠</C_MC>\n"
                + "\t\t\t\t<N_SFZJLX>100</N_SFZJLX>\n"
                + "\t\t\t\t<N_ZZMM>1</N_ZZMM>\n"
                + "\t\t\t\t<N_XWNL>1</N_XWNL>\n"
                + "\t\t\t\t<N_XB>1</N_XB>\n"
                + "\t\t\t\t<C_DSRAJDW>1</C_DSRAJDW>\n"
                + "\t\t\t\t<C_BH_AJ>242a52e09eb52083e11a59a60e4d4274</C_BH_AJ>\n"
                + "\t\t\t\t<C_HJD/>\n"
                + "\t\t\t\t<C_XZZ>青铜峡市青铜峡镇沃沙村2队</C_XZZ>\n"
                + "\t\t\t\t<N_GZDWXZ/>\n"
                + "\t\t\t\t<C_ZJHM>123123123</C_ZJHM>\n"
                + "\t\t\t\t<N_WHCD>110</N_WHCD>\n"
                + "\t\t\t\t<C_GZDWMC/>\n"
                + "\t\t\t\t<N_MZ>1</N_MZ>\n"
                + "\t\t\t\t<N_FDMSAJDW/>\n"
                + "\t\t\t\t<N_XH>2</N_XH>\n"
                + "\t\t\t\t<C_TSSF>2</C_TSSF>\n"
                + "\t\t\t\t<C_TSSF>3</C_TSSF>\n"
                + "\t\t\t\t<N_HJSZD>110100</N_HJSZD>\n"
                + "\t\t\t\t<C_FDDBR/>\n"
                + "\t\t\t\t<N_SF>1</N_SF>\n"
                + "\t\t\t\t<C_TSSLHBL>1</C_TSSLHBL>\n"
                + "\t\t\t\t<N_HYZK>10</N_HYZK>\n"
                + "\t\t\t\t<D_CSRQ>2000-12-31 00:00:00.0</D_CSRQ>\n"
                + "\t\t\t\t<C_ZYBSJGSZD/>\n"
                + "\t\t\t\t<N_ZCDGJDQ/>\n"
                + "\t\t\t\t<N_GZDWLX/>\n"
                + "\t\t\t\t<C_SJHM/>\n"
                + "\t\t\t\t<C_DZYX/>\n"
                + "\t\t\t\t<N_JCJZD/>\n"
                + "\t\t\t\t<N_GJ>156</N_GJ>\n"
                + "\t\t\t\t<C_QTLXDH/>\n"
                + "\t\t\t\t<C_BH>a37805b1f72f0901d73e19d14903d7cb</C_BH>\n"
                + "\t\t\t</T_AJ_DSR_AJXQ>\n"
                + "\t\t\t<T_WS_AJXQ>\n"
                + "\t\t\t\t<C_WSMC>民事判决书(一审民事案件用)</C_WSMC>\n"
                + "\t\t\t\t<C_HTM_PROTOCOL>/4000/4016/21/496/401600000047600/1.html</C_HTM_PROTOCOL>\n"
                + "\t\t\t\t<C_BH_AJ>242a52e09eb52083e11a59a60e4d4274</C_BH_AJ>\n"
                + "\t\t\t\t<N_WSLX>4</N_WSLX>\n"
                + "\t\t\t\t<N_WSXH/>\n"
                + "\t\t\t\t<C_BH>88a03d35241ea60b42e0252a949f2f79</C_BH>\n"
                + "\t\t\t</T_WS_AJXQ>\n"
                + "\t\t</T_AJ_AJXQ>\n"
                + "\t</data>\n"
                + "</resource>";
        System.out.println(string);
        return string;
    }

}
