package com.hanqi.test;

import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.DocumentEntry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;

public class TestWord2 {
    public static void main1111(String[] args) {
        try {
            System.out.println(TestDemo.readHtml("E:\\IdeaProjects\\ssmtest\\src\\main\\webapp\\WEB-INF\\jsp\\404.jsp"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        String title = "测试标题";
        String text = "aaaaa测试内容测试内容测试内容测试内容测试内容";
        try {
            //word内容
/*            String content="<html><body>" +
                    "<p style=\"text-align: center;\"><span style=\"font-family: 黑体, SimHei; font-size: 14px;\">"
                    + title + "</span></p>" + text + "</body></html>";*/
//            String content = TestDemo.readHtml("E:\\IdeaProjects\\ssmtest\\src\\main\\webapp\\WEB-INF\\jsp\\404.jsp");
            String content = "<html><p style=\"line-height: 1.75em; text-align: center; text-indent: 0em;\">" +
                    "<img src=\"/uploadfiles/ueditor/image/20170908/1504831633809061654.jpg\" title=\"1504831633809061654.jpg\" " +
                    "alt=\"1_副本_副本.jpg\"/></p><p style=\"text-indent: 2em; line-height: 1.75em;\">你可能没有做你理想的工作。" +
                    "最有可能的是，你赚的钱并不像你想要的那么多。但让我们面对现实：经过过去几年的发展，如今的就业市场已经有了很大的改善，而美国已经接近" +
                    "经济学家所说的“就业饱和状态”，失业率降至近4%。</p><p style=\"text-indent: 2em; line-height: 1.75em;\">但这种有利的趋势" +
                    "掩盖了许多人在某些职业领域的痛苦和混乱，而且这些人数还在不断增多。机器人技术、人工智能和其他压力几乎肯定会在未来几年改变数百万美国人" +
                    "的就业前景，无论是好是坏。以下是工作和就业在未来5-10年可能发生的变化：</p><p style=\"text-indent: 2em; " +
                    "line-height: 1.75em;\"><strong>一、你的同事：机器人</strong></p><p style=\"text-indent: 2em; " +
                    "line-height: 1.75em;\">机器人技术和自动化已经取得了巨大的进展，尤其是在制造业领域。根据牛津大学工程学院2013年的一项研究，" +
                    "在未来20年里，美国近一半的工作岗位，47%的人面临着被自动化代替的风险。</p><p style=\"text-indent: 2em; " +
                    "line-height: 1.75em;\">研究人员调查了700多种职业，考察了员工的工作表现、所需的技能以及目前阻碍计算机化的工程障碍。" +
                    "那些需要创造性和社交技巧的任务，往往风险更小。</p><p style=\"text-indent: 2em; line-height: 1.75em;\">运输、物流和办公室" +
                    "管理方面的工作岗位面临着被替换的风险。无人驾驶汽车，包括大型卡车，已经在高速公路上行驶。根据牛津大学的报告，虽然目前机器人主要应用于制" +
                    "造行业，但接下来可能会有数百万个服务岗位也将使用机器人技术。服务业的自动化可能更为重要，因为服务业比制造业和农业拥有更多的就业机会。</p>" +
                    "<p style=\"text-indent: 2em; line-height: 1.75em;\">最近，鲍尔州立大学的一项研究列出了一些有可能被自动化的职业。" +
                    "其中包括电话销售人员、保险承保人、纳税申报表编制人员、手表维修人员和输入数据的人。相比之下，那些较低风险的职业包括休闲理疗师、社会工作者" +
                    "、技工监督人员、卫生技术人员和助听器专家。</p><p style=\"text-indent: 2em; line-height: 1.75em;\">技术进步是一把双刃剑。" +
                    "他们会使得一些工作消失，但也会创造其他的工作机会。</p><p style=\"text-indent: 2em; line-height: 1.75em;\">例如，在零售业" +
                    "，自动化带来了自助式的收银通道。不过，Gray&amp;Christmas公司的首席执行官John Challenger说，电脑化的阅读眼镜或护目镜的使用将让" +
                    "购物者能够在食品杂货店的货架上寻找一些具有特定性质的食物。其他新兴产品或应用程序能够帮助你使用智能手机更方便地检测和识别想要的产品。</p>" +
                    "<p style=\"text-indent: 2em; line-height: 1.75em;\">“一些新技术最终将创造就业机会，”他说。“有使用增强现实或虚拟现实经验的员" +
                    "工将会拥有最多的机会，那些能够帮助引导客户新体验或培训员工的人也是如此。”</p>" +
                    "<p style=\"line-height: 1.75em; text-align: center; text-indent: 0em;\">" +
                    "<img src=\"/uploadfiles/ueditor/image/20170908/1504831665664025667.jpg\" title=\"1504831665664025667.jpg\" " +
                    "alt=\"2_副本_副本.jpg\"/></p><p style=\"text-indent: 2em; line-height: 1.75em;\"><strong>二、机器人革命</strong>" +
                    "</p><p style=\"text-indent: 2em; line-height: 1.75em;\">最终，机器人和自动化的普及将成为全国性的趋势。但到目前为止，尤其是" +
                    "对机器人来说，影响力已经非常集中。布鲁金斯学会最近绘制了工业机器人的流行趋势，并指出美在国中西部各州以及汽车工业集中的南部地区，机器人" +
                    "使用数量较为集中。</p><p style=\"text-indent: 2em; line-height: 1.75em;\">报告称，在美国中西部和南部各州的233,300个工" +
                    "业机器人中，有超过一半的工作是“焊接、喷漆、组装产品、处理材料或包装物品”。仅在密歇根州，就有12%的工业机器人，而在所有西方国家，" +
                    "这一比例仅为13%。俄亥俄州、印第安纳州和田纳西州也广泛使用机器人。</p><p style=\"text-indent: 2em; line-height: 1.75em;\">" +
                    "工业机器人的使用将会减少一些工作岗位，包括危险的、重复性的和体力强度大的工作，但它可以创造新的工作机会。亚利桑那州立大学的助理工程教授" +
                    "Heni Ben Amor说，除了需要机器设计、维护和编程的工程师之外，最终其他人也会与机器人并肩工作。</p>" +
                    "<p style=\"text-indent: 2em; line-height: 1.75em;\">他说：“在过去，机器人身体上有个缺陷，因为如果你不幸被一个人机器人击中，" +
                    "就会很危险。新的趋势将把两个世界融合在一起。”例如，他说人类可以做一些灵活工作，比如安装小螺丝钉，而机器人则负责做需要体力和重复性的工" +
                    "作。</p><p style=\"text-indent: 2em; line-height: 1.75em;\"><strong>三、挥之不去的不安感</strong></p>" +
                    "<p style=\"line-height: 1.75em; text-align: center; text-indent: 0em;\"><img src=\"/uploadfiles/ueditor/image/20170908/1504831684921045359.jpg\" title=\"1504831684921045359.jpg\" alt=\"3_副本_副本.jpg\"/></p><p style=\"text-indent: 2em; line-height: 1.75em;\">Ben Amor说，机器人技术的进步可能会带来就业机会，他对此感到很兴奋。“所创造的就业机会将比被消除的就业机会多得多，”他预测道。</p><p style=\"text-indent: 2em; line-height: 1.75em;\">Ben Amor认为无人驾驶汽车是在机器人技术旗帜下倒下的，因为两者都涉及到机器或系统感知环境的变化，并采取相应的行动。他认为，鉴于优步、Alphabet、通用汽车和英特尔等公司都在硅谷附近的公共道路上测试了这种车辆，亚利桑那州在无人驾驶汽车和卡车的开发上可能会有一个光明的前景。</p><p style=\"text-indent: 2em; line-height: 1.75em;\">他说，这里的测试异常集中，吸引了许多聪明的学生和年轻企业家的注意，他们想要为这些公司工作，或者自己创业。不过，机器人和人工智能的采用往往会让公众担心有一天会失业。这种焦虑蔓延到了政治领域。布鲁金斯学会在报告中指出：“有证据表明，去年十一月红色州(共和党)投给特朗普总统的机器人投票率是蓝色州(民主党)投给希拉里.克林顿的两倍多。”</p><p style=\"text-indent: 2em; line-height: 1.75em;\">亚利桑那州的机器人数量较少，因此也就没有机器人所引发的焦虑感，但该州在其他方面却落后于其他州，比如岗位、经济繁荣和就业方面。</p><p style=\"text-indent: 2em; line-height: 1.75em;\">例如，根据Prosperity Now杂志的一份报告，亚利桑那州的低收入工作比例(27.8%)略高于全国平均水平的24.2%。在亚利桑那州，平均工资为49,700美元，这比美国平均水平低3,200美元，而当地雇主为员工提供医疗保险的比例也略低于美国平均水平。</p><p style=\"text-indent: 2em; line-height: 1.75em;\"><strong>四、工作岗位依然存在，但受教育程度需要不断提高</strong></p><p style=\"line-height: 1.75em; text-align: center; text-indent: 0em;\"><img src=\"/uploadfiles/ueditor/image/20170908/1504831703529077684.jpg\" title=\"1504831703529077684.jpg\" alt=\"4_副本_副本.jpg\"/></p><p style=\"text-indent: 2em; line-height: 1.75em;\">来自机器人、人工智能和全球外包的压力是很严重的，但前景并不完全是黯淡的。整个国家的经济是强健的、有弹性的和具有创新力的。新行业将会创造出新的就业机会，就像过去经常发生的那样。</p><p style=\"text-indent: 2em; line-height: 1.75em;\">乔治敦大学教育和劳动力中心最近的一项研究估计，对于没有大学学历的人来说，仍然会有3000万个“好工作”。这些工作的中位数年薪为55,000美元(最低35,000美元)。其中很多工作都是在医疗保健、金融和信息技术领域。</p><p style=\"text-indent: 2em; line-height: 1.75em;\">这样的职位已经稳步取代了传统蓝领行业以前的好工作。例如，25年前，一个机械工人赚了44,000美元，这是一份不错的制造业工作。如今，这一描述适用于一名年薪6万美元的电脑支持技术人员。报告中列举的其他好工作例子包括财务经理、销售代表和工程技术人员。</p><p style=\"text-indent: 2em; line-height: 1.75em;\">尽管如此，该研究指出，对好工作的教育要求正在上升。虽然不必具备大学学位，但仍需要接受过高等教育。对于那些没有高中文凭的人来说，好工作的数量自1991年以来已经减少了100万多人。相比之下，拥有大专学历的工人从事好工作的数量在此期间增加了300万人。</p><p style=\"text-indent: 2em; line-height: 1.75em;\">“为了有效竞争，工人需要接受一定程度的高等教育和培训，”报告称。“此外，有时为了获得这些工作，或者在这些工作岗位上取得进步，还需要有各种各样的非学历证书。”</p><p style=\"text-indent: 2em; line-height: 1.75em;\"><strong>五、恢复贸易工作岗位</strong></p><p style=\"line-height: 1.75em; text-align: center; text-indent: 0em;\"><img src=\"/uploadfiles/ueditor/image/20170908/1504831722061048841.jpg\" title=\"1504831722061048841.jpg\" alt=\"5_副本_副本.jpg\"/></p><p style=\"text-indent: 2em; line-height: 1.75em;\">高等教育固然重要，但许多高薪工作并不需要花在大学课堂上的时间。据估计，在亚利桑那州的建筑行业，大约有1万个或更多的岗位空缺——比如水管工、电工、干墙专家、木匠和其他某些职位。</p><p style=\"text-indent: 2em; line-height: 1.75em;\">Brewer公司是一家大型的管道公司，其中包括水管的零售业务，它在吸引工人就业方面遇到了困难，以至于它放缓了增长速度，从而让客户服务和质量不受影响。该公司的首席执行官Mike Brewer说，公司正在寻找合适的人选来填补35个空缺职位，今年至少会增长15%。</p><p style=\"text-indent: 2em; line-height: 1.75em;\">Brewer为那些想成为水管工的人提供了带薪实习机会。我们不需要有以往的工作经验，但申请者必须要有责任心，并对工作充满热情。“这些人会准时上班然后工作一整天吗？”他问道。“这不是什么很难的事。”</p><p style=\"text-indent: 2em; line-height: 1.75em;\"><strong>六、前途光明的职业</strong></p><p style=\"text-indent: 2em; line-height: 1.75em;\">除了机器人技术、外国竞争和教育因素，其他因素也会影响就业。因此，行业的优势或劣势、客户需求等等都是如此。</p><p style=\"text-indent: 2em; line-height: 1.75em;\">Kiplinger最近整理了785种职业，根据当前的平均工资水平和未来的增长前景，本别收集了10种最优和最差的职业。</p><p style=\"text-indent: 2em; line-height: 1.75em;\">10个最佳职业主要集中在科技和医疗保健领域。在科技领域，发展前景好的职位包括应用开发者和计算机系统分析师，而医疗行业则为护理师、理疗师、健康服务经理、医师助理、牙科保健师和语言障碍矫正师。市场研究分析师和金融顾问位于Kiplinger研究的前十名之列。</p><p style=\"text-indent: 2em; line-height: 1.75em;\">而最糟糕的职业则是多种多样的，其中包括纺织工人、照片处理人员、家具精加工人员、金属/塑料机械操作员、印刷装订工和印刷工人等许多制造业岗位。机器人技术以及技术的进步，正在让这些工作岗位变得不那么重要。</p><p style=\"text-indent: 2em; line-height: 1.75em;\">据报道，其他一些前景不佳的职位，部分原因是由于他们的竞争非常激烈，或者工资不高，这些职位包括电台/电视播音员、立法者、花卉设计师、游戏收银员和上门推销人员。</p><p style=\"text-indent: 2em; line-height: 1.75em;\">STEM领域的工作——那些从事科学、技术、工程或数学的工作——享有特别好的就业前景。Challenger说：“未来的工作，无论是行业还是水平，毫无疑问都会涉及到至少一项技术的基础知识。”他补充说，进入STEM行业的人将在竞争中占据优势。</p><p style=\"text-indent: 2em; line-height: 1.75em;\">2017年，该公司列举了STEM最关注的职位，包括计算机系统分析师、统计学家、软件开发人员、数学家和财务顾问。这些领域的平均工资已经超过了8万美元，失业率低于2.5%。</p><p style=\"line-height: 1.75em; text-align: center; text-indent: 0em;\"><img src=\"/uploadfiles/ueditor/image/20170908/1504831742952040819.jpg\" title=\"1504831742952040819.jpg\" alt=\"6_副本_副本.jpg\"/></p><p style=\"text-indent: 2em; line-height: 1.75em;\"><strong>七、兼职工作：选择不断扩大？</strong></p><p style=\"text-indent: 2em; line-height: 1.75em;\">人们的假设是，大多数人想要拥有具备一系列福利的全职工作，但事实并非如此。事实上，目前有超过六分之一的美国人从事兼职工作，其中很多人是在家工作的。</p><p style=\"text-indent: 2em; line-height: 1.75em;\">求职网站FlexJobs的首席执行官Sara Sutton Fell说，兼职或远程工作对双职工父母、半退休人员、有健康问题的人、军人配偶和职业改变者来说是理想的工作选择。</p><p style=\"text-indent: 2em; line-height: 1.75em;\">她指出，各种规模的公司以及各行各业的公司都雇佣远程兼职工作者，比如护士、会计师和数字营销策略家。家庭教师、作家和编辑、计算机程序员、翻译和客服代表也同样如此。</p><p style=\"text-indent: 2em; line-height: 1.75em;\">随着婴儿潮一代的健康状况良好，对于年轻的退休人员来说，兼职工作仍然是一个很有吸引力的选择——这是一种保持社会参与度、同时获得额外收入的有效方式。事实上，在最近由员工福利研究所进行的调查中，79%的员工表示他们计划在退休后工作。然而，在同一项调查中，只有29%的退休人员表示，他们实际上是在工作，或者是在为获取收入而工作。</p><p style=\"text-indent: 2em; line-height: 1.75em;\">这项调查发现，现在的劳动者对就业的期望与退休人员的比例之间存在很大的差距。但是随着一些职业的就业机会短缺和工作灵活性的增加，退休人员的兼职工作在未来几年可能会更加适用。</p></html>";
            byte b[] = content.getBytes("UTF-8");  //这里是必须要设置编码的，不然导出中文就会乱码。
            ByteArrayInputStream bais = new ByteArrayInputStream(b);//将字节数组包装到流中

            /*
             * 关键地方
             * 生成word格式 */
            POIFSFileSystem poifs = new POIFSFileSystem();
            DirectoryEntry directory = poifs.getRoot();
            DocumentEntry documentEntry = directory.createDocument("WordDocument", bais);
            //输出文件
/*            request.setCharacterEncoding("utf-8");
            response.setContentType("application/msword");//导出word格式
            response.addHeader("Content-Disposition", "attachment;filename=" +
                    new String(title.getBytes("GB2312"),"iso8859-1") + ".doc");
            ServletOutputStream ostream = response.getOutputStream();*/
            FileOutputStream ostream = new FileOutputStream(new File("e:\\aaaa.doc"));
            poifs.writeFilesystem(ostream);
            bais.close();
            ostream.close();
            poifs.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
