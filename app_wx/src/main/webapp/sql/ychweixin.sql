/*
Navicat MySQL Data Transfer

Source Server         : 192.168.25.188
Source Server Version : 50635
Source Host           : 192.168.25.188:3306
Source Database       : ychweixin

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2017-01-24 17:13:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `wx_menu_tree`
-- ----------------------------
DROP TABLE IF EXISTS `wx_menu_tree`;
CREATE TABLE `wx_menu_tree` (
  `id` varchar(32) NOT NULL DEFAULT '' COMMENT '节点ID',
  `pid` varchar(32) DEFAULT NULL COMMENT '父节点',
  `name` varchar(20) DEFAULT NULL COMMENT '节点名称',
  `url` varchar(255) DEFAULT NULL COMMENT '节点URL',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wx_menu_tree
-- ----------------------------
INSERT INTO `wx_menu_tree` VALUES ('1', '0', '反馈问题', null);
INSERT INTO `wx_menu_tree` VALUES ('10', '1', '用户问题列表', 'jsp/question/user_question_list.jsp');
INSERT INTO `wx_menu_tree` VALUES ('11', '1', '客服回复列表', 'jsp/question/reply_question_list.jsp');
INSERT INTO `wx_menu_tree` VALUES ('12', '1', '常见问题列表', 'jsp/question/commonQuestion.jsp');
INSERT INTO `wx_menu_tree` VALUES ('2', '0', '系统监控', null);
INSERT INTO `wx_menu_tree` VALUES ('20', '2', '项目监控', 'monitoring');
INSERT INTO `wx_menu_tree` VALUES ('3', '0', '统计模块 ', null);
INSERT INTO `wx_menu_tree` VALUES ('31', '3', '日活跃用户统计', 'jsp/statistics/day_activity_user.jsp');

-- ----------------------------
-- Table structure for `wx_question`
-- ----------------------------
DROP TABLE IF EXISTS `wx_question`;
CREATE TABLE `wx_question` (
  `id` varchar(32) NOT NULL DEFAULT '' COMMENT '消息标识',
  `wx_user_id` varchar(32) DEFAULT '' COMMENT '微信用户ID',
  `wx_user_phone` varchar(11) DEFAULT '' COMMENT '用户手机号',
  `wx_user_question_img` varchar(255) DEFAULT NULL COMMENT '问题图片URL',
  `wx_user_question_content` text COMMENT '问题内容',
  `wx_user_question_title` varchar(255) DEFAULT NULL COMMENT '问题标题',
  `wx_user_question_type` varchar(32) DEFAULT NULL COMMENT '问题类型',
  `reply_question_img` varchar(255) DEFAULT NULL COMMENT '回复问题图片',
  `reply_question_content` text COMMENT '回复问题',
  `reply_question_human` varchar(32) DEFAULT NULL COMMENT '回复人',
  `createTime` varchar(32) DEFAULT NULL COMMENT '问题创建时间',
  `completeTime` varchar(32) DEFAULT NULL COMMENT '问题回复时间',
  `status` int(1) DEFAULT '0' COMMENT '0待解决（用户提出）1待确认（客服回复）3待跟踪（其它部门）4已解决（用户确认）5未解决（用户确认）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wx_question
-- ----------------------------
INSERT INTO `wx_question` VALUES ('04a0d4fd98204faab7980724f1ff3efa', 'oD0h4wyiHi93D-kMfyZmrYfRMEN0', '111111', 'pic3396907214293674090.jpg,pic3741037115446054778.jpg,pic492164578026606318.jpg,pic2925091622206565662.jpg', '阿里郎恶魔', '标题', '其它', null, '哈哈哈哈', '我的中国心', '2016-09-01 14:11:44', '2016-09-19 17:18:25', '1');
INSERT INTO `wx_question` VALUES ('079a4cca079d427e97d826c97b0f5eba', 'oD0h4wyiHi93D-kMfyZmrYfRMEN0', '25875563', '20160914171838490237.jpg', '嗯问问', '标题', '物流', null, 'List     rpush(key, value)：在名称为key的list尾添加一个值为value的元素    lpush(key, value)：在名称为key的list头添加一个值为value的 元素    llen(key)：返回名称为key的list的长度    lrange(key, start, end)：返回名称为key的list中start至end之间的元素    ltrim(key, start, end)：截取名称为key的list    lindex(key, index)：返回名称为key的list中index位置的元素    lset(key, index, value)：给名称为key的list中index位置的元素赋值    lrem(key, count, value)：删除count个key的list中值为value的元素    lpop(key)：返回并删除名称为key的list中的首元素    rpop(key)：返回并删除名称为key的list中的尾元素    blpop(key1, key2,… key N, timeout)：lpop命令的block版本。    brpop(key1, key2,… key N, timeout)：rpop的block版本。    rpoplpush(srckey, dstkey)：返回并删除名称为srckey的list的尾元素，　　　　　　　　　　　　　　并将该元素添加到名称为dstkey的list的头部     sadd(key, member)：向名称为key的set中添加元素member    srem(key, member) ：删除名称为key的set中的元素member    spop(key) ：随机返回并删除名称为key的set中一个元素    smove(srckey, dstkey, member) ：移到集合元素    scard(key) ：返回名称为key的set的基数    sismember(key, member) ：member是否是名称为key的set的元素    sinter(key1, key2,…key N) ：求交集    sinterstore(dstkey, (keys)) ：求交集并将交集保存到dstkey的集合    sunion(key1, (keys)) ：求并集    sunionstore(dstkey, (keys)) ：求并集并将并集保存到dstkey的集合    sdiff(key1, (keys)) ：求差集    sdiffstore(dstkey, (keys)) ：求差集并将差集保存到dstkey的集合    smembers(key) ：返回名称为key的set的所有元素    srandmember(key) ：随机返回名称为key的set的一个元素', '我的中国心', '2016-09-14 17:18:46', '2016-09-19 10:06:16', '1');
INSERT INTO `wx_question` VALUES ('09053e37248442c2bf54a8a4916bc7b3', 'oD0h4wyiHi93D-kMfyZmrYfRMEN0', '恶魔', '20160914095812045629.jpg,20160914095813027629.jpg,20160914095812208428.jpg', '红烧肉', '标题', '物流', null, '你好啊', '我的中国心', '2016-09-14 09:59:44', '2016-09-19 16:35:17', '1');
INSERT INTO `wx_question` VALUES ('1004a22480df4db48200632ef66de5d0', 'oD0h4wyiHi93D-kMfyZmrYfRMEN0', '111111', 'pic4281560423055265943.jpg,pic2722625634464355407.jpg,pic3270740828232362861.jpg,pic6482197187353284389.jpg', '阿里郎', '标题', '书籍', null, '你好吗？', '我的中国心', '2016-09-01 22:27:23', '2016-09-19 16:40:20', '1');
INSERT INTO `wx_question` VALUES ('12b5c4a21fa24269b2016f74d389c08c', 'oD0h4wyiHi93D-kMfyZmrYfRMEN0', '258756', 'pic1749439704119034234.jpg,pic2792707684688950193.jpg,pic592771410360014718.jpg,pic7215656442617750120.jpg,pic4673585070488235498.jpg', '恶魔', '标题', '其它', null, '十五字十五字十五字十五字十五字', '我的中国心', '2016-08-31 11:05:50', '2016-08-31 15:27:44', '4');
INSERT INTO `wx_question` VALUES ('2605bde650fd405ca1d2492be1880d3d', 'oD0h4wyiHi93D-kMfyZmrYfRMEN0', '2585258', '', 'Emmy', '标题', '购买', null, '<p>hehe</p>', '我的中国心', '2016-08-31 11:09:10', '2016-08-31 13:38:44', '4');
INSERT INTO `wx_question` VALUES ('28379ad123914be6b8ba9d1e092bd854', 'oD0h4wyiHi93D-kMfyZmrYfRMEN0', '1111', 'pic3941631849613487692.jpg,pic7130667671277421267.jpg,pic544094674734538152.jpg,pic6624556475096160771.jpg', '阿里郎', '标题', '观看', null, '风景怡人', '我的中国心', '2016-08-31 11:03:57', '2016-09-08 05:23:56', '3');
INSERT INTO `wx_question` VALUES ('47f47ff034fc4b55ace208139ad7b8d5', 'oD0h4wyiHi93D-kMfyZmrYfRMEN0', '18201508823', 'pic7531854943663449431.jpg,pic1811482898677925939.jpg,pic6820107628670754618.jpg,pic859705205450464035.jpg,pic7097466539802371684.jpg', '真的吗？', '标题', '观看', null, '大夺夺夺夺夺夺我的中国心洋装虽然穿在身我心已然是中国人，我的祖先早已把我的一切烙上中国印', '我的中国心', '2016-08-31 11:09:27', '2016-09-18 16:14:44', '3');
INSERT INTO `wx_question` VALUES ('536a94b9cdc64a13a51409b4e8839ed7', 'oD0h4wyiHi93D-kMfyZmrYfRMEN0', '111', '20160914094737245647.jpg', '阿里郎', '标题', '物流', null, '你好啊', '我的中国心', '2016-09-14 09:48:02', '2016-09-19 16:36:54', '1');
INSERT INTO `wx_question` VALUES ('75c53bc20b704db5baa5ae3f4fd4494d', 'oD0h4wyiHi93D-kMfyZmrYfRMEN0', '15698523521', '20160921101157733531.jpg', '没问题', '测试题', '观看', null, '真的没问题？', '我的中国心', '2016-09-21 10:11:57', '2016-09-21 10:13:58', '5');
INSERT INTO `wx_question` VALUES ('7adaf468855247309c2471697bf3878e', 'oD0h4wyiHi93D-kMfyZmrYfRMEN0', '123456', 'pic3023500200915578101.jpg,pic1536982769649360043.jpg,pic601476313744311839.jpg', '阿鲁巴', '标题', '物流', null, '曾国藩（1811-1872） 初名子城，字伯函，号涤生，谥文正，湖南长沙府湘乡（今湖南省双峰县）人。中国清朝时期的军事家、理学家、政治家，书法家，「中兴名臣」之一，也是文学家，晚清散文「湘乡派」创立人。官至两江总督、直隶总督、武英殿大学士，封一等毅勇侯。湖南长沙府湘乡白杨坪人，现属湖南省双峰县荷叶镇天子坪。 曾国藩于嘉庆十六年（1811年）出生于湖南省双峰县井字镇荷叶塘的一个豪门地主家庭。兄妹九人，曾国藩为长子。祖辈以农为主，生活较为宽裕。祖父曾玉屏虽少文化，但阅历丰富；父亲曾麟书身为塾师秀才，作为长子长孙的曾国藩，自然得到二位先辈的伦理教育了。 曾国藩6岁时入塾读书，8岁能读八股文诵五经，14岁时能读周礼、史记文选，并参加长沙的童子试，成绩俱佳列为优等，可见他自幼天资聪明，勤奋好学。至道光十二年（1832年）他考取了秀才，并与欧阳沧溟之女成婚。 曾国藩28岁便考中了进士，从此之后，他一步一阶的踏上仕途之路，并成为军机大臣穆彰阿的得意门生。在京十多年间，他先后任翰林院庶吉士，累迁侍读，侍讲学士，文渊阁值阁事，内阁学士，稽察中书科事务，礼部侍郎及署兵部，工部，刑部，吏部侍郎等职，曾国藩就是沿着这封仕途之道，步步升迁到二品官位。十年七迁，连跃十级，从七品一跃而为二品大员， 曾国藩的一生和镇压太平天国起义是分不开的。咸丰二年（1852年），曾国藩因母丧在家。这时太平天国的起义已席卷半个中国，尽管清政府从全国各地调集大量八旗、绿营官兵来对付太平军，可是这支腐朽的武装不堪一击。因此，清政府屡次颁发奖励团练的命令，力图利用各地的地主武装来遏制革命势力的发展，这就为曾国藩的湘军的出现，提供了一个机会。咸丰三年（1853年）藉著清政府给予寻求力量镇压太平天国的时机，他因势在其家乡湖南一带，依靠师徒、亲戚、好友等复杂的人际关系，建立了一支地方团练，称为湘军。曾国藩残酷镇压太平天国起义，用刑苛酷，史称「派知州一人，照磨一人承审匪类，解到重则立决，轻则毙之杖下，又轻则鞭之千百。……案至即时讯供，即时正法，亦无所期待迁延」。不仅他自己直接杀人，他的父亲和四弟也杀人，即有人责其杀人过多，称呼为「曾剃头」、「曾屠户」。据说，南京小孩夜哭，妈妈说「曾剃头来了」，小孩就不哭了。在和太平军作战中，曾国藩用劫掠财物、封官赏爵的办法来鼓舞士气，养成湘军凶悍领残的本性。湘军在军事素质落后的清朝武装力量中成为中国南方地区与太平天国军事力量作战的主力之一。曾国藩被封为一等勇毅侯，成为清代以文人而封武侯的第一人，后历任两江总督、直隶总督，官居一品， 曾国藩一生著述颇多，但以《家书》流传最广，影响最大。光绪五年（1879年），也就是曾国藩死后7年，传忠书局刻印了由李瀚章、李鸿章编校的《曾文正公家书》。 曾国藩本人也善于运用人才，清朝另外一些名臣如左宗棠、李鸿章都与他有密切关系。左宗棠、李鸿章等称呼曾国藩为老师。曾国藩曾说“李少荃拼命做官，俞荫甫（俞樾）拼命著书”。  太平天国失败后，太平军在江北的余部与捻军汇合，清廷命曾国藩督办直隶、山东、河南三省军务。曾国藩带领湘军二万，淮军六万，配备洋枪洋炮，北上“剿捻”，他的方针是“重迎剿，不重尾追”，并提出“重点设防”等计划，妄图把捻军阻击在运河、沙河地区，使捻军无处可逃，然后加以消灭。但是捻军突破了曾国藩的防线，进入山东，使曾国藩的战略计划全部破产。曾国藩被免职，由李鸿章接代。 同治九年（1870年），正在直隶总督任上的曾国藩奉命前往天津办理天津教案。1870年6月21日，天津数千名群众因怀疑天主教堂以育婴堂为晃子拐骗人口、虐杀婴儿，群集在法国天主教堂前面。法国领事丰大业认为官方没有认真弹压，持枪在街上碰到天津知县刘杰，因发生争执开枪射击，当场击死刘杰仆人一人，民众激愤之下先杀死了法国驻天津领事丰大业及其秘书西门，之后又杀死了10名修女、2名神父、另外2名法国领事馆人员、2名法国侨民、3名俄国侨民和30多名中国信徒，焚毁了法国领事馆、望海楼天主堂以及当地英美传教士开办的4座基督教堂。事件发生后，英、美、法等国联合提出抗议，并出动军舰逞威。曾国藩到天津后，考量当时局势，不愿与法国开战，“但冀和局之速成，不问情罪之一当否”，在法国的要求下，商议决定最后处死为首杀人的18人，充军流放25人，并将天津知府张光藻、知县刘杰被革职充军发配到黑龙江，赔偿外国人的损失46万两银，并由崇厚派使团至法国道歉。这个交涉结果，朝廷人士及民众舆论均甚为不满，使曾国藩的声誉大受影响，引起全国朝野的垂骂，连他的湖南同乡，也把他在湖广会馆夸耀其功名的匾额砸烂焚毁。 同治十一年二月初四(公历：1872年3月20日）在南京病逝。朝廷赠太傅，死后被谥“文正”。其家族后代多出官宦，如曾纪泽等。', '我的中国心', '2016-08-31 11:06:16', '2016-09-18 16:19:12', '0');
INSERT INTO `wx_question` VALUES ('7e270a94ddbe44c2bcefeb9609f2abae', 'oD0h4wyiHi93D-kMfyZmrYfRMEN0', '236547896', '20160917164614343011.jpg,20160917164618866407.jpg,20160917164626202610.jpg', '测试', '标题', '物流', null, '曾国藩（1811-1872） 初名子城，字伯函，号涤生，谥文正，湖南长沙府湘乡（今湖南省双峰县）人。中国清朝时期的军事家、理学家、政治家，书法家，「中兴名臣」之一，也是文学家，晚清散文「湘乡派」创立人。官至两江总督、直隶总督、武英殿大学士，封一等毅勇侯。湖南长沙府湘乡白杨坪人，现属湖南省双峰县荷叶镇天子坪。 曾国藩于嘉庆十六年（1811年）出生于湖南省双峰县井字镇荷叶塘的一个豪门地主家庭。兄妹九人，曾国藩为长子。祖辈以农为主，生活较为宽裕。祖父曾玉屏虽少文化，但阅历丰富；父亲曾麟书身为塾师秀才，作为长子长孙的曾国藩，自然得到二位先辈的伦理教育了。 曾国藩6岁时入塾读书，8岁能读八股文诵五经，14岁时', '我的中国心', '2016-09-17 16:46:39', '2016-09-18 17:18:32', '1');
INSERT INTO `wx_question` VALUES ('9237258767e9483ca599e4d43a42dd79', 'oD0h4wyiHi93D-kMfyZmrYfRMEN0', '111111', 'pic5425549013417310793.jpg,pic8864089879934060076.jpg,pic2637277751808009175.jpg', '阿里郎', '标题', '其它', null, '老爹', '我的中国心', '2016-08-31 14:20:42', '2016-09-18 15:48:29', '0');
INSERT INTO `wx_question` VALUES ('93e3361d2cc64ae7a53a6b3bad81f4fa', 'oD0h4wyiHi93D-kMfyZmrYfRMEN0', '1111', 'pic3941631849613487692.jpg,pic7130667671277421267.jpg,pic544094674734538152.jpg,pic6624556475096160771.jpg', '阿里郎', '标题', '观看', null, '阿西巴', '我的中国心', '2016-08-31 12:35:59', '2016-09-17 07:29:24', '3');
INSERT INTO `wx_question` VALUES ('a8c1a96ec8c5499aab15308eafbed5c6', 'oD0h4wyiHi93D-kMfyZmrYfRMEN0', '123546879', 'pic7844649445479987919.jpg,pic5295806441075018639.jpg,pic1632959830662774325.jpg,pic6108264841499596552.jpg', '阿里郎红烧肉', '标题', '购买', null, 'Spring是一个开源框架，Spring是于2003 年兴起的一个轻量级的Java 开发框架，由Rod Johnson 在其著作Expert One-On-One J2EE Development and Design中阐述的部分理念和原型衍生而来。它是为了解决企业应用开发的复杂性而创建的。框架的主要优势之一就是其分层架构，分层架构允许使用者选择使用哪一个组件，同时为 J2EE 应用程序开发提供集成的框架。Spring使用基本的JavaBean来完成以前只可能由EJB完成的事情。然而，Spring的用途不仅限于服务器端的开发。从简单性、可测试性和松耦合的角度而言，任何Java应用都可以从Spring中受益。Spring的核心是控制反转(IoC)和面向切面(AOP)。简单来说，Spring是一个分层的JavaSE/EEfull-stack(一站式) 轻量级开源框架。', '我的中国心', '2016-09-01 14:07:54', '2016-09-02 18:35:12', '3');
INSERT INTO `wx_question` VALUES ('b6e072c09b514186865bafb5a03f7742', 'oD0h4wyiHi93D-kMfyZmrYfRMEN0', '111111', 'pic4513590385715667064.jpg,pic1748478835597010346.jpg', 'gggsss', '标题', '物流', null, '中国共产党，简称中共，成立于1921年7月，1949年10月至今为代表工人阶级领导工农联盟和统一战线，在中国大陆实行人民民主专政的中华人民共和国唯一执政党。中国工人阶级的先锋队，中国社会主义事业的领导核心，中国各族人民利益的代表者。', '我的中国心', '2016-09-01 14:15:04', '2016-09-18 15:11:23', '1');
INSERT INTO `wx_question` VALUES ('ce54f38d867147ae946813387cc34fbc', 'oD0h4wyiHi93D-kMfyZmrYfRMEN0', '11111111111', 'pic8853892033910861363.jpg,pic3417346040033015138.jpg,pic1722236503420764514.jpg,pic439343472832293831.jpg,pic7749140974631916318.jpg', '阿里郎阿里郎', '标题', '观看', null, '你好吗？', '我的中国心', '2016-09-01 14:17:13', '2016-09-19 16:42:28', '1');
INSERT INTO `wx_question` VALUES ('e134dc137afb44ad82406c15087344fe', 'oD0h4wyiHi93D-kMfyZmrYfRMEN0', '阿里郎', '20160914161329354273.jpg', '恶魔', '标题', '物流', null, '你好啊', '我的中国心', '2016-09-14 16:13:38', '2016-09-19 16:32:39', '1');
INSERT INTO `wx_question` VALUES ('e87c8426ce6e42a5b2fc4c78f09411df', 'oD0h4wyiHi93D-kMfyZmrYfRMEN0', '258', '', '257885555', '标题', '其它', null, '曾国藩（1811-1872） 初名子城，字伯函，号涤生，谥文正，湖南长沙府湘乡（今湖南省双峰县）人。中国清朝时期的军事家、理学家、政治家，书法家，「中兴名臣」之一，也是文学家，晚清散文「湘乡派」创立人。官至两江总督、直隶总督、武英殿大学士，封一等毅勇侯。湖南长沙府湘乡白杨坪人，现属湖南省双峰县荷叶镇天子坪。 曾国藩于嘉庆十六年（1811年）出生于湖南省双峰县井字镇荷叶塘的一个豪门地主家庭。兄妹九人，曾国藩为长子。祖辈以农为主，生活较为宽裕。祖父曾玉屏虽少文化，但阅历丰富；父亲曾麟书身为塾师秀才，作为长子长孙的曾国藩，自然得到二位先辈的伦理教育了。 曾国藩6岁时入塾读书，8岁能读八股文诵五经，14岁时能读周礼、史记文选，并参加长沙的童子试，成绩俱佳列为优等，可见他自幼天资聪明，勤奋好学。至道光十二年（1832年）他考取了秀才，并与欧阳沧溟之女成婚。 曾国藩28岁便考中了进士，从此之后，他一步一阶的踏上仕途之路，并成为军机大臣穆彰阿的得意门生。在京十多年间，他先后任翰林院庶吉士，累迁侍读，侍讲学士，文渊阁值阁事，内阁学士，稽察中书科事务，礼部侍郎及署兵部，工部，刑部，吏部侍郎等职，曾国藩就是沿着这封仕途之道，步步升迁到二品官位。十年七迁，连跃十级，从七品一跃而为二品大员， 曾国藩的一生和镇压太平天国起义是分不开的。咸丰二年（1852年），曾国藩因母丧在家。这时太平天国的起义已席卷半个中国，尽管清政府从全国各地调集大量八旗、绿营官兵来对付太平军，可是这支腐朽的武装不堪一击。因此，清政府屡次颁发奖励团练的命令，力图利用各地的地主武装来遏制革命势力的发展，这就为曾国藩的湘军的出现，提供了一个机会。咸丰三年（1853年）藉著清政府给予寻求力量镇压太平天国的时机，他因势在其家乡湖南一带，依靠师徒、亲戚、好友等复杂的人际关系，建立了一支地方团练，称为湘军。曾国藩残酷镇压太平天国起义，用刑苛酷，史称「派知州一人，照磨一人承审匪类，解到重则立决，轻则毙之杖下，又轻则鞭之千百。……案至即时讯供，即时正法，亦无所期待迁延」。不仅他自己直接杀人，他的父亲和四弟也杀人，即有人责其杀人过多，称呼为「曾剃头」、「曾屠户」。据说，南京小孩夜哭，妈妈说「曾剃头来了」，小孩就不哭了。在和太平军作战中，曾国藩用劫掠财物、封官赏爵的办法来鼓舞士气，养成湘军凶悍领残的本性。湘军在军事素质落后的清朝武装力量中成为中国南方地区与太平天国军事力量作战的主力之一。曾国藩被封为一等勇毅侯，成为清代以文人而封武侯的第一人，后历任两江总督、直隶总督，官居一品， 曾国藩一生著述颇多，但以《家书》流传最广，影响最大。光绪五年（1879年），也就是曾国藩死后7年，传忠书局刻印了由李瀚章、李鸿章编校的《曾文正公家书》。 曾国藩本人也善于运用人才，清朝另外一些名臣如左宗棠、李鸿章都与他有密切关系。左宗棠、李鸿章等称呼曾国藩为老师。曾国藩曾说“李少荃拼命做官，俞荫甫（俞樾）拼命著书”。  太平天国失败后，太平军在江北的余部与捻军汇合，清廷命曾国藩督办直隶、山东、河南三省军务。曾国藩带领湘军二万，淮军六万，配备洋枪洋炮，北上“剿捻”，他的方针是“重迎剿，不重尾追”，并提出“重点设防”等计划，妄图把捻军阻击在运河、沙河地区，使捻军无处可逃，然后加以消灭。但是捻军突破了曾国藩的防线，进入山东，使曾国藩的战略计划全部破产。曾国藩被免职，由李鸿章接代。 同治九年（1870年），正在直隶总督任上的曾国藩奉命前往天津办理天津教案。1870年6月21日，天津数千名群众因怀疑天主教堂以育婴堂为晃子拐骗人口、虐杀婴儿，群集在法国天主教堂前面。法国领事丰大业认为官方没有认真弹压，持枪在街上碰到天津知县刘杰，因发生争执开枪射击，当场击死刘杰仆人一人，民众激愤之下先杀死了法国驻天津领事丰大业及其秘书西门，之后又杀死了10名修女、2名神父、另外2名法国领事馆人员、2名法国侨民、3名俄国侨民和30多名中国信徒，焚毁了法国领事馆、望海楼天主堂以及当地英美传教士开办的4座基督教堂。事件发生后，英、美、法等国联合提出抗议，并出动军舰逞威。曾国藩到天津后，考量当时局势，不愿与法国开战，“但冀和局之速成，不问情罪之一当否”，在法国的要求下，商议决定最后处死为首杀人的18人，充军流放25人，并将天津知府张光藻、知县刘杰被革职充军发配到黑龙江，赔偿外国人的损失46万两银，并由崇厚派使团至法国道歉。这个交涉结果，朝廷人士及民众舆论均甚为不满，使曾国藩的声誉大受影响，引起全国朝野的垂骂，连他的湖南同乡，也把他在湖广会馆夸耀其功名的匾额砸烂焚毁。 同治十一年二月初四(公历：1872年3月20日）在南京病逝。朝廷赠太傅，死后被谥“文正”。其家族后代多出官宦，如曾纪泽等。', '我的中国心', '2016-09-14 19:59:11', '2016-09-18 17:34:04', '1');

-- ----------------------------
-- Table structure for `wx_question_tree`
-- ----------------------------
DROP TABLE IF EXISTS `wx_question_tree`;
CREATE TABLE `wx_question_tree` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '问题ID',
  `pid` int(11) NOT NULL COMMENT '上级ID',
  `question` varchar(255) NOT NULL COMMENT '问题描述',
  `p_question` varchar(255) DEFAULT NULL COMMENT '上级问题描述',
  `question_type` varchar(255) DEFAULT NULL COMMENT '问题类型',
  `createTime` varchar(255) DEFAULT NULL COMMENT '创建时间',
  `updateTime` varchar(255) DEFAULT NULL COMMENT '修改时间',
  `code` int(5) DEFAULT '0' COMMENT '子节点个数',
  PRIMARY KEY (`id`),
  KEY `pid` (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=152 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wx_question_tree
-- ----------------------------
INSERT INTO `wx_question_tree` VALUES ('1', '0', '物流问题', '', '物流', '2016-09-20 06:28:22', '2016-09-22 18:48:18', '2');
INSERT INTO `wx_question_tree` VALUES ('39', '1', '发货时间', '物流问题', '物流', '2016-09-22 17:15:12', '2016-09-27 15:10:55', '1');
INSERT INTO `wx_question_tree` VALUES ('103', '39', '我们将在与您取得联系、核对赠送书目、收货地址后的5个工作日内发货。', '发货时间', '物流', '2016-09-23 15:41:34', '2016-09-27 15:10:40', '0');
INSERT INTO `wx_question_tree` VALUES ('105', '0', '送书问题', '', '书籍', '2016-09-23 15:45:35', '2016-09-27 15:06:00', '4');
INSERT INTO `wx_question_tree` VALUES ('113', '0', '购买问题', '', '购买', '2016-09-27 15:05:29', null, '2');
INSERT INTO `wx_question_tree` VALUES ('115', '1', '是否可以指定快递', '物流问题', '物流', '2016-09-27 15:06:22', null, '1');
INSERT INTO `wx_question_tree` VALUES ('117', '115', '默认快递为中通、圆通、百世汇通，原则上不接受指定快递。', '是否可以指定快递', '物流', '2016-09-27 15:08:29', '2016-09-27 15:08:44', '0');
INSERT INTO `wx_question_tree` VALUES ('119', '105', '如何获得赠送的图书', '送书问题', '书籍', '2016-09-27 15:11:26', null, '1');
INSERT INTO `wx_question_tree` VALUES ('121', '119', '通过联通IPTV应用商城，进入学习佳，包年或包半年订购学习佳产品，将获得对应年级、学科的辅导书。', '如何获得赠送的图书', '书籍', '2016-09-27 15:13:20', null, '0');
INSERT INTO `wx_question_tree` VALUES ('123', '105', '包年和包半年送的书有什么区别', '送书问题', '书籍', '2016-09-27 15:13:51', null, '1');
INSERT INTO `wx_question_tree` VALUES ('125', '123', '包年赠送一学年教辅，包半年赠送一学期教辅。', '包年和包半年送的书有什么区别', '书籍', '2016-09-27 15:13:57', null, '0');
INSERT INTO `wx_question_tree` VALUES ('127', '105', '赠送书籍收到之后可否退换', '送书问题', '书籍', '2016-09-27 15:15:11', null, '3');
INSERT INTO `wx_question_tree` VALUES ('129', '127', '书籍没有质量问题', '赠送书籍收到之后可否退换', '书籍', '2016-09-27 15:16:54', null, '1');
INSERT INTO `wx_question_tree` VALUES ('131', '129', '不予退换', '书籍没有质量问题', '书籍', '2016-09-27 15:17:13', null, '0');
INSERT INTO `wx_question_tree` VALUES ('133', '127', '书籍有质量问题', '赠送书籍收到之后可否退换', '书籍', '2016-09-27 15:17:27', null, '1');
INSERT INTO `wx_question_tree` VALUES ('135', '127', '书籍与约定书单不符', '赠送书籍收到之后可否退换', '书籍', '2016-09-27 15:18:28', null, '1');
INSERT INTO `wx_question_tree` VALUES ('137', '133', '请您于收到书后的15个工作日内联系人工客服，我们将为您重新寄送出问题的书籍。', '书籍有质量问题', '书籍', '2016-09-27 15:19:43', null, '0');
INSERT INTO `wx_question_tree` VALUES ('139', '135', '请您于收到书后的15个工作日内联系人工客服，我们将为您重新寄送书籍，并请您将与约定书单不符的书籍寄回，运费有我公司承担。', '书籍与约定书单不符', '书籍', '2016-09-27 15:21:14', null, '0');
INSERT INTO `wx_question_tree` VALUES ('141', '113', '如何购买学习佳产品', '购买问题', '购买', '2016-09-27 15:21:32', null, '1');
INSERT INTO `wx_question_tree` VALUES ('143', '141', '通过TV端学习佳专区或下载TV端学习佳APP，可购买学习佳包月、包年、包半年套餐。购买包年或包半年套餐，将获赠北京教育出版社畅销明星教辅图书一套。', '如何购买学习佳产品', '购买', '2016-09-27 15:23:39', null, '0');
INSERT INTO `wx_question_tree` VALUES ('145', '113', '购买课程后能否退订', '购买问题', '购买', '2016-09-27 15:25:16', null, '1');
INSERT INTO `wx_question_tree` VALUES ('147', '145', '包月购买可通过联通IPTV应用商城退订；包年、包半年产品不可退订。', '购买课程后能否退订', '购买', '2016-09-27 15:25:58', null, '0');
INSERT INTO `wx_question_tree` VALUES ('149', '105', '赠送图书书目', '送书问题', '书籍', '2016-09-27 15:26:42', null, '1');
INSERT INTO `wx_question_tree` VALUES ('151', '149', '在您购买课程时弹出的购买提示页面中，点击送书活动-配送书籍详情可查看各年级对应的赠送书目。', '赠送图书书目', '书籍', '2016-09-27 15:37:44', null, '0');

-- ----------------------------
-- Table structure for `wx_system_config`
-- ----------------------------
DROP TABLE IF EXISTS `wx_system_config`;
CREATE TABLE `wx_system_config` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `value` text,
  `content` varchar(255) DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wx_system_config
-- ----------------------------
INSERT INTO `wx_system_config` VALUES ('menu', '<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n<root>\r\n  <onemenu name=\"公司简介\">\r\n      <submenu name=\"公司首页\" type=\"view\" key=\"http://uflowertv.com/\"></submenu>\r\n			<submenu name=\"公司介绍\" type=\"click\" key=\"company_js\"></submenu>\r\n  </onemenu>\r\n  <twomenu name=\"登录注册\">\r\n      <submenu name=\"注册\" type=\"view\" key=\"http://weixin.u-flower.net/wxpublic/html/login.html\"></submenu>\r\n  </twomenu>\r\n  <threemenu name=\"客服服务\">\r\n			<submenu name=\"机器人问答\" type=\"view\" key=\"http://weixin.u-flower.net/wxpublic/html/wx_service/wx_service.html\"></submenu>\r\n      <submenu name=\"问题反馈\" type=\"view\" key=\"http://weixin.u-flower.net/wxpublic/main/userinfo.do?type=user_question\"></submenu>\r\n  </threemenu>\r\n</root>\r\n\r\n', '创建菜单', '2016-08-11 17:52:09');

-- ----------------------------
-- Table structure for `wx_system_user`
-- ----------------------------
DROP TABLE IF EXISTS `wx_system_user`;
CREATE TABLE `wx_system_user` (
  `id` varchar(32) NOT NULL DEFAULT '' COMMENT '用户唯一标识',
  `pwd` varchar(32) NOT NULL COMMENT '登录密码',
  `uname` varchar(32) DEFAULT NULL COMMENT '用户昵称',
  `email` varchar(255) NOT NULL COMMENT '登录邮箱',
  `created` varchar(255) NOT NULL COMMENT '创建时间',
  `loginTime` varchar(255) NOT NULL COMMENT '登录时间',
  `validatecode` varchar(32) DEFAULT NULL COMMENT '邮件SID',
  `outdate` datetime DEFAULT NULL COMMENT '邮件有效期',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_wx_user_email` (`email`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wx_system_user
-- ----------------------------
INSERT INTO `wx_system_user` VALUES ('5ad5a95a78d94a59909d04ed8b132ec4', 'B852AE43CA65371E8EC6AF99596555A2', 'msdsej帅', 'msdsej@163.com', '2016-09-22 17:18:26', '2016-09-28 15:57:21', null, null);
INSERT INTO `wx_system_user` VALUES ('76139e71340b41028055a05233a7531d', '50A81F0B0A759F04AFFA86A097A39659', '油菜花王敏', 'wangmin@uflowertv.com', '2016-09-22 17:14:53', '2016-09-22 17:33:20', null, null);
INSERT INTO `wx_system_user` VALUES ('85424ff58ab64809a011d8721a7f56b5', 'E807F1FCF82D132F9BB018CA6738A19F', 'liude', 'liude@uflowertv.com', '2016-09-21 18:19:59', '2016-09-22 17:11:23', null, null);
INSERT INTO `wx_system_user` VALUES ('8cf25881743340c3a519565c845ff8a2', 'E3CEB5881A0A1FDAAD01296D7554868D', '王二小123', '261338952@qq.com', '2016-09-23 15:45:08', '2016-12-26 13:19:23', '78d823f751104e12b8666cb10dcc4825', '2016-12-26 13:55:14');
INSERT INTO `wx_system_user` VALUES ('97d09bd6c2994e97ab72fc5da47f4ec8', '96E79218965EB72C92A549DD5A330112', '我的中国心', '275018155@qq.com', '2016-10-18 15:52:28', '2017-01-22 12:58:14', '77d27d83d9e7467494b15cfe85d420c2', '2017-01-22 13:27:05');
INSERT INTO `wx_system_user` VALUES ('c1427ec3633e48d6abd9572e570acce5', '8E39E0E0CDB2F52FD0DB8EE1BD90FEED', 'liheng', 'liheng@uflowertv.com', '2016-09-22 17:13:12', '2016-09-27 14:46:18', null, null);

-- ----------------------------
-- Table structure for `wx_user`
-- ----------------------------
DROP TABLE IF EXISTS `wx_user`;
CREATE TABLE `wx_user` (
  `openid` varchar(32) NOT NULL DEFAULT '' COMMENT '用户唯一标识',
  `subscribe` int(1) DEFAULT NULL COMMENT '0未关注1关注',
  `nickname` varchar(32) DEFAULT NULL COMMENT '用户昵称',
  `sex` int(1) DEFAULT NULL COMMENT '0未知1男2女',
  `city` varchar(32) DEFAULT NULL COMMENT '城市',
  `country` varchar(32) DEFAULT NULL COMMENT '国家',
  `province` varchar(32) DEFAULT NULL COMMENT '省市自治区',
  `language` varchar(12) NOT NULL DEFAULT 'zh_CN' COMMENT '语言',
  `headimgurl` varchar(255) DEFAULT NULL COMMENT '头像URL',
  `subscribeTime` varchar(20) DEFAULT NULL COMMENT '关注时间',
  `unionid` varchar(32) DEFAULT NULL COMMENT '只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段',
  `remark` varchar(32) DEFAULT NULL COMMENT '粉丝的备注',
  `groupid` int(32) DEFAULT '0' COMMENT '用户所在的分组ID',
  PRIMARY KEY (`openid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wx_user
-- ----------------------------
INSERT INTO `wx_user` VALUES ('oD0h4wyiHi93D-kMfyZmrYfRMEN0', '0', '王二小', '1', '太原', '中国', '山西', 'zh_CN', 'http://wx.qlogo.cn/mmopen/qntLGG2FXQAu3xicvveH1jNtBxpic9qiagEcHrxxdM5bEdJ9rDICYMVhdq9T4uAbcFuiazZpp3AiajgGYlr39rTKqqQnOf2TPNjss/0', '1474423888', null, '', '0');
INSERT INTO `wx_user` VALUES ('ojxUcwz2-PYDzS8110klaAry53KQ', '1', '李国梁', '1', '太原', '中国', '山西', 'zh_CN', 'http://wx.qlogo.cn/mmopen/dibCvqHg4WnevUdJjY2dl9T9RIrHq3YvpiaXwlYf8ktAHumPYQfmuS294xa1dLsLkjyVLPuMKaxqYgEG6HVSOyLw/0', '1472017890', null, '', '0');

-- ----------------------------
-- Table structure for `wx_user_phone_code`
-- ----------------------------
DROP TABLE IF EXISTS `wx_user_phone_code`;
CREATE TABLE `wx_user_phone_code` (
  `phone` varchar(11) NOT NULL DEFAULT '' COMMENT '手机号',
  `code` varchar(6) DEFAULT NULL COMMENT '验证码',
  `amount` tinyint(2) DEFAULT NULL COMMENT '验证总数',
  `time` date DEFAULT NULL COMMENT '验证时间',
  PRIMARY KEY (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wx_user_phone_code
-- ----------------------------
INSERT INTO `wx_user_phone_code` VALUES ('18201508823', '414582', '2', '2016-09-18');
