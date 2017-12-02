package z.com.bean;

import java.util.List;

import z.com.base.BaseBean;

/**
 * Created by lenovo on 2017/12/1.
 */

public class VideoBean extends BaseBean{


    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * commentNum : 2
         * comments : [{"cid":7,"content":"评论评论评论","createTime":"2017-11-27T23:34:37","jid":null,"mvp":null,"praiseNum":0,"uid":72,"wid":2},{"cid":8,"content":"评论评论评论","createTime":"2017-11-27T23:34:41","jid":null,"mvp":null,"praiseNum":0,"uid":71,"wid":2}]
         * cover : https://www.zhaoapi.cn/images/icon.png
         * createTime : 2017-11-28T11:34:09
         * favoriteNum : 0
         * latitude : null
         * localUri : null
         * longitude : null
         * playNum : null
         * praiseNum : 1
         * uid : 72
         * user : {"age":null,"fans":"null","follow":"null","icon":"https://www.zhaoapi.cn/images/72.jpg","nickname":"QQ","praiseNum":"null"}
         * videoUrl : https://www.zhaoapi.cn/
         * wid : 2
         * workDesc : 我是描述2
         */

        private int commentNum;
        private String cover;
        private String createTime;
        private int favoriteNum;
        private Object latitude;
        private Object localUri;
        private Object longitude;
        private Object playNum;
        private int praiseNum;
        private int uid;
        private UserBean user;
        private String videoUrl;
        private int wid;
        private String workDesc;
        private List<CommentsBean> comments;

        public int getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(int commentNum) {
            this.commentNum = commentNum;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public int getFavoriteNum() {
            return favoriteNum;
        }

        public void setFavoriteNum(int favoriteNum) {
            this.favoriteNum = favoriteNum;
        }

        public Object getLatitude() {
            return latitude;
        }

        public void setLatitude(Object latitude) {
            this.latitude = latitude;
        }

        public Object getLocalUri() {
            return localUri;
        }

        public void setLocalUri(Object localUri) {
            this.localUri = localUri;
        }

        public Object getLongitude() {
            return longitude;
        }

        public void setLongitude(Object longitude) {
            this.longitude = longitude;
        }

        public Object getPlayNum() {
            return playNum;
        }

        public void setPlayNum(Object playNum) {
            this.playNum = playNum;
        }

        public int getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(int praiseNum) {
            this.praiseNum = praiseNum;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public String getVideoUrl() {
            return videoUrl;
        }

        public void setVideoUrl(String videoUrl) {
            this.videoUrl = videoUrl;
        }

        public int getWid() {
            return wid;
        }

        public void setWid(int wid) {
            this.wid = wid;
        }

        public String getWorkDesc() {
            return workDesc;
        }

        public void setWorkDesc(String workDesc) {
            this.workDesc = workDesc;
        }

        public List<CommentsBean> getComments() {
            return comments;
        }

        public void setComments(List<CommentsBean> comments) {
            this.comments = comments;
        }

        public static class UserBean {
            /**
             * age : null
             * fans : null
             * follow : null
             * icon : https://www.zhaoapi.cn/images/72.jpg
             * nickname : QQ
             * praiseNum : null
             */

            private Object age;
            private String fans;
            private String follow;
            private String icon;
            private String nickname;
            private String praiseNum;

            public Object getAge() {
                return age;
            }

            public void setAge(Object age) {
                this.age = age;
            }

            public String getFans() {
                return fans;
            }

            public void setFans(String fans) {
                this.fans = fans;
            }

            public String getFollow() {
                return follow;
            }

            public void setFollow(String follow) {
                this.follow = follow;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getPraiseNum() {
                return praiseNum;
            }

            public void setPraiseNum(String praiseNum) {
                this.praiseNum = praiseNum;
            }
        }

        public static class CommentsBean {
            /**
             * cid : 7
             * content : 评论评论评论
             * createTime : 2017-11-27T23:34:37
             * jid : null
             * mvp : null
             * praiseNum : 0
             * uid : 72
             * wid : 2
             */

            private int cid;
            private String content;
            private String createTime;
            private Object jid;
            private Object mvp;
            private int praiseNum;
            private int uid;
            private int wid;

            public int getCid() {
                return cid;
            }

            public void setCid(int cid) {
                this.cid = cid;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public Object getJid() {
                return jid;
            }

            public void setJid(Object jid) {
                this.jid = jid;
            }

            public Object getMvp() {
                return mvp;
            }

            public void setMvp(Object mvp) {
                this.mvp = mvp;
            }

            public int getPraiseNum() {
                return praiseNum;
            }

            public void setPraiseNum(int praiseNum) {
                this.praiseNum = praiseNum;
            }

            public int getUid() {
                return uid;
            }

            public void setUid(int uid) {
                this.uid = uid;
            }

            public int getWid() {
                return wid;
            }

            public void setWid(int wid) {
                this.wid = wid;
            }
        }
    }
}


