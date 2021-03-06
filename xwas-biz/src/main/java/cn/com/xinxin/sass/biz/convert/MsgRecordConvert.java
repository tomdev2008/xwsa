package cn.com.xinxin.sass.biz.convert;

/*
 *
 * Copyright 2020 www.xinxindigits.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software
 * and associated documentation files (the "Software"),to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice
 * shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 * Redistribution and selling copies of the software are prohibited, only if the authorization from xinxin digits
 * was obtained.Neither the name of the xinxin digits; nor the names of its contributors may be used to
 * endorse or promote products derived from this software without specific prior written permission.
 *
 */

import cn.com.xinxin.sass.common.constants.CommonConstants;
import cn.com.xinxin.sass.common.constants.WeChatWorkChatRecordsTypeConstants;
import cn.com.xinxin.sass.common.enums.SassBizResultCodeEnum;
import cn.com.xinxin.sass.repository.model.MsgRecordDO;
import cn.com.xinxin.sass.sal.model.wechatwork.WeChatWorkChattingRecordsBO;
import com.xinxinfinance.commons.exception.BusinessException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: liuhangzhou
 * @created: 2020/4/27.
 * @updater:
 * @description:
 */
public class MsgRecordConvert {

    private static final Logger LOGGER = LoggerFactory.getLogger(MsgRecordConvert.class);

    /**
     * 将WeChatWorkChattingRecordsBO转化为MsgRecordDO
     * @param recordsBO 聊天记录
     * @param orgId 机构id
     * @param taskId 任务id
     * @param seqId 消息序列号
     * @return MsgRecordDO
     */
    public static MsgRecordDO convert2MsgRecordDO(WeChatWorkChattingRecordsBO recordsBO,
                                                  String orgId, String taskId, Long seqId) {
        MsgRecordDO msgRecordDO = new MsgRecordDO();
        msgRecordDO.setTenantId(orgId);
        msgRecordDO.setSeqId(seqId);
        msgRecordDO.setMsgId(recordsBO.getMsgId());
        msgRecordDO.setAction(recordsBO.getAction());
        msgRecordDO.setTaskId(taskId);
        msgRecordDO.setGmtCreator(CommonConstants.GMT_CREATOR_SYSTEM);
        if (StringUtils.equals(msgRecordDO.getAction(), WeChatWorkChatRecordsTypeConstants.SWITCH)) {
            msgRecordDO.setFromUserId(recordsBO.getUser());
            msgRecordDO.setMsgTime(recordsBO.getTime());
            return msgRecordDO;
        }
        msgRecordDO.setFromUserId(recordsBO.getFrom());
        msgRecordDO.setRoomId(recordsBO.getRoomId());
        msgRecordDO.setMsgTime(recordsBO.getMsgTime());
        msgRecordDO.setMsgType(recordsBO.getMsgType());
        msgRecordDO.setToUserId(recordsBO.getToList().toString());
        switch(msgRecordDO.getMsgType()) {
            case WeChatWorkChatRecordsTypeConstants.TEXT :
                msgRecordDO.setContent(recordsBO.getText());
                break;
            case WeChatWorkChatRecordsTypeConstants.AGREE :
                msgRecordDO.setContent(recordsBO.getAgree());
                break;
            case WeChatWorkChatRecordsTypeConstants.CALENDAR :
                msgRecordDO.setContent(recordsBO.getCalendar());
                break;
            case WeChatWorkChatRecordsTypeConstants.CARD :
                msgRecordDO.setContent(recordsBO.getCard());
                break;
            case WeChatWorkChatRecordsTypeConstants.CHATRECORD :
                msgRecordDO.setContent(recordsBO.getChatrecord());
                break;
            case WeChatWorkChatRecordsTypeConstants.COLLECT :
                msgRecordDO.setContent(recordsBO.getCollect());
                break;
            case WeChatWorkChatRecordsTypeConstants.DISAGREE :
                msgRecordDO.setContent(recordsBO.getDisagree());
                break;
            case WeChatWorkChatRecordsTypeConstants.DOCMSG :
                msgRecordDO.setContent(recordsBO.getDocmsg());
                break;
            case WeChatWorkChatRecordsTypeConstants.EMOTION :
                msgRecordDO.setContent(recordsBO.getEmotion());
                break;
            case WeChatWorkChatRecordsTypeConstants.FILE :
                msgRecordDO.setContent(recordsBO.getFile());
                break;
            case WeChatWorkChatRecordsTypeConstants.IMAGE :
                msgRecordDO.setContent(recordsBO.getImage());
                break;
            case WeChatWorkChatRecordsTypeConstants.LINK :
                msgRecordDO.setContent(recordsBO.getLink());
                break;
            case WeChatWorkChatRecordsTypeConstants.LOCATION :
                msgRecordDO.setContent(recordsBO.getLocation());
                break;
            case WeChatWorkChatRecordsTypeConstants.MARKDOWN :
                msgRecordDO.setContent(recordsBO.getMarkdown());
                break;
            case WeChatWorkChatRecordsTypeConstants.MEETING :
                msgRecordDO.setContent(recordsBO.getMeeting());
                break;
            case WeChatWorkChatRecordsTypeConstants.MIXED :
                msgRecordDO.setContent(recordsBO.getMixed());
                break;
            case WeChatWorkChatRecordsTypeConstants.NEWS :
                msgRecordDO.setContent(recordsBO.getNews());
                break;
            case WeChatWorkChatRecordsTypeConstants.REDPACKET :
                msgRecordDO.setContent(recordsBO.getRedpacket());
                break;
            case WeChatWorkChatRecordsTypeConstants.REVOKE :
                msgRecordDO.setContent(recordsBO.getRevoke());
                break;
            case WeChatWorkChatRecordsTypeConstants.TODO :
                msgRecordDO.setContent(recordsBO.getTodo());
                break;
            case WeChatWorkChatRecordsTypeConstants.VIDEO :
                msgRecordDO.setContent(recordsBO.getVideo());
                break;
            case WeChatWorkChatRecordsTypeConstants.VOTE :
                msgRecordDO.setContent(recordsBO.getVote());
                break;
            case WeChatWorkChatRecordsTypeConstants.VOICE :
                msgRecordDO.setContent(recordsBO.getVoice());
                break;
            case WeChatWorkChatRecordsTypeConstants.WEAPP :
                msgRecordDO.setContent(recordsBO.getWeapp());
                break;
            default:
                LOGGER.error("获取消息记录，消息记录的类型不正确， [{}]", recordsBO.getMsgType());
                throw new BusinessException(SassBizResultCodeEnum.FAIL, "获取消息记录，消息记录的类型不正确");
        }
        return msgRecordDO;
    }
}
