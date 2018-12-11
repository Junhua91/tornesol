package com.junhua.tornesol.util.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

public class JsonExample {

    public static void main(String[] args) {
        String jsonString = "{\n" +
                "\t\"response\": {\n" +
                "\t\t\"docs\": [{\n" +
                "\t\t\t\"verify_type\": 1,\n" +
                "\t\t\t\"upload_source\": 2,\n" +
                "\t\t\t\"title\": \"儿童_黄品冠 - 我不难过(live版)\",\n" +
                "\t\t\t\"tags\": \"儿童故事\",\n" +
                "\t\t\t\"is_v\": true,\n" +
                "\t\t\t\"duration\": 318.0,\n" +
                "\t\t\t\"uid\": 21010,\n" +
                "\t\t\t\"category_title\": \"儿童\",\n" +
                "\t\t\t\"category_id\": 6,\n" +
                "\t\t\t\"nickname\": \"花丛中猥琐的笑530\",\n" +
                "\t\t\t\"album_id\": 85166,\n" +
                "\t\t\t\"is_paid\": false,\n" +
                "\t\t\t\"id\": 254954,\n" +
                "\t\t\t\"album_title\": \"儿童_\",\n" +
                "\t\t\t\"count_play\": 0,\n" +
                "\t\t\t\"count_comment\": 0,\n" +
                "\t\t\t\"count_share\": 0,\n" +
                "\t\t\t\"count_like\": 0,\n" +
                "\t\t\t\"album_cover_path\": \"http://192.168.60.48:8080/group1/M00/1E/11/wKgDplVMID6AdCiVAACBOx_ESYc189.jpg!op_type=3&columns=140&rows=140\",\n" +
                "\t\t\t\"download_path\": \"http://fdfs.test.ximalaya.com/group1/M01/1D/69/wKgD3lVMH7GAGLuwABQqgNWUW70849.aac\",\n" +
                "\t\t\t\"is_trailer\": 0,\n" +
                "\t\t\t\"is_trailer_bool\": false,\n" +
                "\t\t\t\"isDraft\": false,\n" +
                "\t\t\t\"upload_id\": \"u_134038\",\n" +
                "\t\t\t\"waveform\": \"group1/M00/1D/69/wKgD3lVMH8CANMNPAAAG0lWbw280164.js\",\n" +
                "\t\t\t\"user_source\": 2,\n" +
                "\t\t\t\"cover_path\": \"http://192.168.60.48:8080/group1/M01/1D/6A/wKgD3lVMH9uABEa8AACBOx_ESYc889.jpg!op_type=3&columns=180&rows=180\",\n" +
                "\t\t\t\"play_path\": \"http://fdfs.test.ximalaya.com/group1/M00/1E/11/wKgDplVMIC-AP7vAACbfmKxsu5s258.mp3\",\n" +
                "\t\t\t\"play_path_32\": \"http://fdfs.test.ximalaya.com/group1/M01/1E/11/wKgDplVMICmAAHdWABNwFkjgCF0119.mp3\",\n" +
                "\t\t\t\"play_path_64\": \"http://fdfs.test.ximalaya.com/group1/M00/1E/11/wKgDplVMIC-AP7vAACbfmKxsu5s258.mp3\",\n" +
                "\t\t\t\"play_path_aac_v164\": \"\",\n" +
                "\t\t\t\"play_path_aac_v224\": \"\",\n" +
                "\t\t\t\"created_at\": 1431052162000,\n" +
                "\t\t\t\"updated_at\": 1467715531000,\n" +
                "\t\t\t\"created_at_hour\": 22794\n" +
                "\t\t}, {\n" +
                "\t\t\t\"verify_type\": 1,\n" +
                "\t\t\t\"title\": \"tiny118   +2\",\n" +
                "\t\t\t\"tags\": \"儿童故事\",\n" +
                "\t\t\t\"is_v\": true,\n" +
                "\t\t\t\"duration\": 244.0,\n" +
                "\t\t\t\"uid\": 12386,\n" +
                "\t\t\t\"category_title\": \"儿童\",\n" +
                "\t\t\t\"category_id\": 6,\n" +
                "\t\t\t\"nickname\": \"tiny118\",\n" +
                "\t\t\t\"album_id\": 0,\n" +
                "\t\t\t\"is_paid\": false,\n" +
                "\t\t\t\"id\": 202397,\n" +
                "\t\t\t\"album_title\": null,\n" +
                "\t\t\t\"count_play\": 0,\n" +
                "\t\t\t\"count_comment\": 0,\n" +
                "\t\t\t\"count_share\": 0,\n" +
                "\t\t\t\"count_like\": 0,\n" +
                "\t\t\t\"album_cover_path\": null,\n" +
                "\t\t\t\"download_path\": \"http://fdfs.test.ximalaya.com/group1/M01/11/F0/wKgD3lMdHl6AfdyvAA96HWuVmkM741.aac\",\n" +
                "\t\t\t\"is_trailer\": 0,\n" +
                "\t\t\t\"is_trailer_bool\": false,\n" +
                "\t\t\t\"isDraft\": false,\n" +
                "\t\t\t\"upload_id\": \"u_96649\",\n" +
                "\t\t\t\"waveform\": \"group1/M01/12/92/wKgDplMdHqmAIvfGAAAHBhok-6E6370.js\",\n" +
                "\t\t\t\"user_source\": 2,\n" +
                "\t\t\t\"cover_path\": \"http://192.168.60.48:8080/group1/M00/12/92/wKgDplMdHrCAMmoVAAGGB9BlAp0515.jpg!op_type=3&columns=180&rows=180\",\n" +
                "\t\t\t\"play_path\": \"http://fdfs.test.ximalaya.com/group1/M00/12/92/wKgDplMdHqeAZ6KcAB3VUWaKSqs504.mp3\",\n" +
                "\t\t\t\"play_path_32\": \"http://fdfs.test.ximalaya.com/group1/M01/11/F0/wKgD3lMdHmKAUlvxAA7q8999YkM343.mp3\",\n" +
                "\t\t\t\"play_path_64\": \"http://fdfs.test.ximalaya.com/group1/M00/12/92/wKgDplMdHqeAZ6KcAB3VUWaKSqs504.mp3\",\n" +
                "\t\t\t\"play_path_aac_v164\": \"\",\n" +
                "\t\t\t\"play_path_aac_v224\": \"\",\n" +
                "\t\t\t\"created_at\": 1394417220000,\n" +
                "\t\t\t\"updated_at\": 1394417220000,\n" +
                "\t\t\t\"upload_source\": 0,\n" +
                "\t\t\t\"created_at_hour\": 12618\n" +
                "\t\t}, {\n" +
                "\t\t\t\"verify_type\": 1,\n" +
                "\t\t\t\"upload_source\": 2,\n" +
                "\t\t\t\"title\": \"儿童_韩磊 - 天边(live版)\",\n" +
                "\t\t\t\"tags\": \"儿童故事\",\n" +
                "\t\t\t\"is_v\": true,\n" +
                "\t\t\t\"duration\": 299.0,\n" +
                "\t\t\t\"uid\": 21010,\n" +
                "\t\t\t\"category_title\": \"儿童\",\n" +
                "\t\t\t\"category_id\": 6,\n" +
                "\t\t\t\"nickname\": \"花丛中猥琐的笑530\",\n" +
                "\t\t\t\"album_id\": 85166,\n" +
                "\t\t\t\"is_paid\": false,\n" +
                "\t\t\t\"id\": 254953,\n" +
                "\t\t\t\"album_title\": \"儿童_\",\n" +
                "\t\t\t\"count_play\": 0,\n" +
                "\t\t\t\"count_comment\": 0,\n" +
                "\t\t\t\"count_share\": 0,\n" +
                "\t\t\t\"count_like\": 0,\n" +
                "\t\t\t\"album_cover_path\": \"http://192.168.60.48:8080/group1/M00/1E/11/wKgDplVMID6AdCiVAACBOx_ESYc189.jpg!op_type=3&columns=140&rows=140\",\n" +
                "\t\t\t\"download_path\": \"http://fdfs.test.ximalaya.com/group1/M00/1E/11/wKgDplVMICaAffRiABL75i-yZgg183.aac\",\n" +
                "\t\t\t\"is_trailer\": 0,\n" +
                "\t\t\t\"is_trailer_bool\": false,\n" +
                "\t\t\t\"isDraft\": false,\n" +
                "\t\t\t\"upload_id\": \"u_134037\",\n" +
                "\t\t\t\"waveform\": \"group1/M00/1D/69/wKgD3lVMH7GAUHquAAAGYtunBuM4144.js\",\n" +
                "\t\t\t\"user_source\": 2,\n" +
                "\t\t\t\"cover_path\": \"http://192.168.60.48:8080/group1/M00/1E/11/wKgDplVMIEuABFN3AACBOx_ESYc063.jpg!op_type=3&columns=180&rows=180\",\n" +
                "\t\t\t\"play_path\": \"http://fdfs.test.ximalaya.com/group1/M01/1D/69/wKgD3lVMH6-AbLRYACSX31UUBWs833.mp3\",\n" +
                "\t\t\t\"play_path_32\": \"http://fdfs.test.ximalaya.com/group1/M00/1E/11/wKgDplVMIDOAGllPABJMM6X8Za4847.mp3\",\n" +
                "\t\t\t\"play_path_64\": \"http://fdfs.test.ximalaya.com/group1/M01/1D/69/wKgD3lVMH6-AbLRYACSX31UUBWs833.mp3\",\n" +
                "\t\t\t\"play_path_aac_v164\": \"\",\n" +
                "\t\t\t\"play_path_aac_v224\": \"\",\n" +
                "\t\t\t\"created_at\": 1431052161000,\n" +
                "\t\t\t\"updated_at\": 1467712513000,\n" +
                "\t\t\t\"created_at_hour\": 22794\n" +
                "\t\t}, {\n" +
                "\t\t\t\"verify_type\": 1,\n" +
                "\t\t\t\"upload_source\": 2,\n" +
                "\t\t\t\"title\": \"Lotus\",\n" +
                "\t\t\t\"tags\": \"儿童故事\",\n" +
                "\t\t\t\"is_v\": true,\n" +
                "\t\t\t\"duration\": 91.0,\n" +
                "\t\t\t\"uid\": 21085,\n" +
                "\t\t\t\"category_title\": \"儿童\",\n" +
                "\t\t\t\"category_id\": 6,\n" +
                "\t\t\t\"nickname\": \"claire26\",\n" +
                "\t\t\t\"album_id\": 86086,\n" +
                "\t\t\t\"is_paid\": false,\n" +
                "\t\t\t\"id\": 257670,\n" +
                "\t\t\t\"album_title\": \"儿童claire26 type: 13\",\n" +
                "\t\t\t\"count_play\": 0,\n" +
                "\t\t\t\"count_comment\": 0,\n" +
                "\t\t\t\"count_share\": 0,\n" +
                "\t\t\t\"count_like\": 0,\n" +
                "\t\t\t\"album_cover_path\": null,\n" +
                "\t\t\t\"download_path\": \"http://fdfs.test.ximalaya.com/group1/M01/1E/4B/wKgD3lVWrk-ANQwNAAXNmntBu3o139.aac\",\n" +
                "\t\t\t\"is_trailer\": 0,\n" +
                "\t\t\t\"is_trailer_bool\": false,\n" +
                "\t\t\t\"isDraft\": false,\n" +
                "\t\t\t\"upload_id\": \"u_137770\",\n" +
                "\t\t\t\"waveform\": \"group1/M00/1E/4B/wKgD3lVWrlCAaOBsAAAHeyZf26Y1443.js\",\n" +
                "\t\t\t\"user_source\": 2,\n" +
                "\t\t\t\"cover_path\": null,\n" +
                "\t\t\t\"play_path\": \"http://fdfs.test.ximalaya.com/group1/M01/1E/F1/wKgDplVWrs6AL459AAsvTrmXd-I877.mp3\",\n" +
                "\t\t\t\"play_path_32\": \"http://fdfs.test.ximalaya.com/group1/M00/1E/F1/wKgDplVWrtCAftEcAAWX4X8C558227.mp3\",\n" +
                "\t\t\t\"play_path_64\": \"http://fdfs.test.ximalaya.com/group1/M01/1E/F1/wKgDplVWrs6AL459AAsvTrmXd-I877.mp3\",\n" +
                "\t\t\t\"play_path_aac_v164\": \"\",\n" +
                "\t\t\t\"play_path_aac_v224\": \"\",\n" +
                "\t\t\t\"created_at\": 1431744004000,\n" +
                "\t\t\t\"updated_at\": 1431918364000,\n" +
                "\t\t\t\"created_at_hour\": 22986\n" +
                "\t\t}, {\n" +
                "\t\t\t\"verify_type\": 1,\n" +
                "\t\t\t\"upload_source\": 2,\n" +
                "\t\t\t\"title\": \"儿童_张宇 - 离爱不远(live版)\",\n" +
                "\t\t\t\"tags\": \"儿童故事\",\n" +
                "\t\t\t\"is_v\": true,\n" +
                "\t\t\t\"duration\": 335.0,\n" +
                "\t\t\t\"uid\": 21010,\n" +
                "\t\t\t\"category_title\": \"儿童\",\n" +
                "\t\t\t\"category_id\": 6,\n" +
                "\t\t\t\"nickname\": \"花丛中猥琐的笑530\",\n" +
                "\t\t\t\"album_id\": 85166,\n" +
                "\t\t\t\"is_paid\": false,\n" +
                "\t\t\t\"id\": 254951,\n" +
                "\t\t\t\"album_title\": \"儿童_\",\n" +
                "\t\t\t\"count_play\": 0,\n" +
                "\t\t\t\"count_comment\": 0,\n" +
                "\t\t\t\"count_share\": 0,\n" +
                "\t\t\t\"count_like\": 0,\n" +
                "\t\t\t\"album_cover_path\": \"http://192.168.60.48:8080/group1/M00/1E/11/wKgDplVMID6AdCiVAACBOx_ESYc189.jpg!op_type=3&columns=140&rows=140\",\n" +
                "\t\t\t\"download_path\": \"http://fdfs.test.ximalaya.com/group1/M01/1E/11/wKgDplVMIDiATv0WABVGQlgvExo021.aac\",\n" +
                "\t\t\t\"is_trailer\": 0,\n" +
                "\t\t\t\"is_trailer_bool\": false,\n" +
                "\t\t\t\"isDraft\": false,\n" +
                "\t\t\t\"upload_id\": \"u_134040\",\n" +
                "\t\t\t\"waveform\": \"group1/M01/1E/11/wKgDplVMIDGAZc_BAAAHKU8cMaU8346.js\",\n" +
                "\t\t\t\"user_source\": 2,\n" +
                "\t\t\t\"cover_path\": \"http://192.168.60.48:8080/group1/M00/1E/11/wKgDplVMIEmAfGVyAACBOx_ESYc801.jpg!op_type=3&columns=180&rows=180\",\n" +
                "\t\t\t\"play_path\": \"http://fdfs.test.ximalaya.com/group1/M00/1D/69/wKgD3lVMH76AP4zOACkChONpHOY695.mp3\",\n" +
                "\t\t\t\"play_path_32\": \"http://fdfs.test.ximalaya.com/group1/M01/1D/69/wKgD3lVMH8yAXnj7ABSBiv4C7Rs838.mp3\",\n" +
                "\t\t\t\"play_path_64\": \"http://fdfs.test.ximalaya.com/group1/M00/1D/69/wKgD3lVMH76AP4zOACkChONpHOY695.mp3\",\n" +
                "\t\t\t\"play_path_aac_v164\": \"\",\n" +
                "\t\t\t\"play_path_aac_v224\": \"\",\n" +
                "\t\t\t\"created_at\": 1431052158000,\n" +
                "\t\t\t\"updated_at\": 1437564394000,\n" +
                "\t\t\t\"created_at_hour\": 22794\n" +
                "\t\t}, {\n" +
                "\t\t\t\"verify_type\": 1,\n" +
                "\t\t\t\"title\": \"黄绮珊 - 一样的月光(live版)\",\n" +
                "\t\t\t\"tags\": \"儿童故事\",\n" +
                "\t\t\t\"is_v\": true,\n" +
                "\t\t\t\"duration\": 406.0,\n" +
                "\t\t\t\"uid\": 2255,\n" +
                "\t\t\t\"category_title\": \"儿童\",\n" +
                "\t\t\t\"category_id\": 6,\n" +
                "\t\t\t\"nickname\": \"tinytiny\",\n" +
                "\t\t\t\"album_id\": 74450,\n" +
                "\t\t\t\"is_paid\": false,\n" +
                "\t\t\t\"id\": 136343,\n" +
                "\t\t\t\"album_title\": null,\n" +
                "\t\t\t\"count_play\": 0,\n" +
                "\t\t\t\"count_comment\": 0,\n" +
                "\t\t\t\"count_share\": 0,\n" +
                "\t\t\t\"count_like\": 0,\n" +
                "\t\t\t\"album_cover_path\": null,\n" +
                "\t\t\t\"download_path\": \"http://fdfs.test.ximalaya.com/group1/M01/0A/12/wKgDplIAcK2AKeX0ADGgOODfhUU574.mp3\",\n" +
                "\t\t\t\"is_trailer\": 0,\n" +
                "\t\t\t\"is_trailer_bool\": false,\n" +
                "\t\t\t\"isDraft\": false,\n" +
                "\t\t\t\"upload_id\": \"u_33069\",\n" +
                "\t\t\t\"waveform\": \"group1/M00/09/6B/wKgD3lIAcK2AItc1AAAGdiY_1ck2310.js\",\n" +
                "\t\t\t\"user_source\": 1,\n" +
                "\t\t\t\"cover_path\": \"http://192.168.60.48:8080/group1/M01/0A/12/wKgDplIAcNKAYkoCAACHv3H8_sQ541.jpg!op_type=3&columns=180&rows=180\",\n" +
                "\t\t\t\"play_path\": \"http://fdfs.test.ximalaya.com/group1/M01/0A/12/wKgDplIAcK2AKeX0ADGgOODfhUU574.mp3\",\n" +
                "\t\t\t\"play_path_32\": \"http://fdfs.test.ximalaya.com/group1/M01/0A/12/wKgDplIAcKiAL_QfABjQYu9HG9k914.mp3\",\n" +
                "\t\t\t\"play_path_64\": \"http://fdfs.test.ximalaya.com/group1/M01/0A/12/wKgDplIAcK2AKeX0ADGgOODfhUU574.mp3\",\n" +
                "\t\t\t\"play_path_aac_v164\": \"\",\n" +
                "\t\t\t\"play_path_aac_v224\": \"\",\n" +
                "\t\t\t\"created_at\": 1375760591000,\n" +
                "\t\t\t\"updated_at\": 1375760591000,\n" +
                "\t\t\t\"upload_source\": 0,\n" +
                "\t\t\t\"created_at_hour\": 7435\n" +
                "\t\t}, {\n" +
                "\t\t\t\"verify_type\": 1,\n" +
                "\t\t\t\"upload_source\": 2,\n" +
                "\t\t\t\"title\": \"Three_Bear\",\n" +
                "\t\t\t\"tags\": \"儿童故事\",\n" +
                "\t\t\t\"is_v\": true,\n" +
                "\t\t\t\"duration\": 60.0,\n" +
                "\t\t\t\"uid\": 13001,\n" +
                "\t\t\t\"category_title\": \"儿童\",\n" +
                "\t\t\t\"category_id\": 6,\n" +
                "\t\t\t\"nickname\": \"tiny209_修改\",\n" +
                "\t\t\t\"album_id\": 85263,\n" +
                "\t\t\t\"is_paid\": false,\n" +
                "\t\t\t\"id\": 255467,\n" +
                "\t\t\t\"album_title\": \"New2015 05 08 12 08 49\",\n" +
                "\t\t\t\"count_play\": 9,\n" +
                "\t\t\t\"count_comment\": 0,\n" +
                "\t\t\t\"count_share\": 0,\n" +
                "\t\t\t\"count_like\": 0,\n" +
                "\t\t\t\"album_cover_path\": null,\n" +
                "\t\t\t\"download_path\": \"http://fdfs.test.ximalaya.com/group1/M01/1E/2F/wKgDplVMOj2Afa6RAAPRWuMUuJk010.aac\",\n" +
                "\t\t\t\"is_trailer\": 0,\n" +
                "\t\t\t\"is_trailer_bool\": false,\n" +
                "\t\t\t\"isDraft\": false,\n" +
                "\t\t\t\"upload_id\": \"u_134773\",\n" +
                "\t\t\t\"waveform\": \"group1/M01/1E/2F/wKgDplVMOjqAC_TnAAAGvu5lr-Y1557.js\",\n" +
                "\t\t\t\"user_source\": 2,\n" +
                "\t\t\t\"cover_path\": null,\n" +
                "\t\t\t\"play_path\": \"http://fdfs.test.ximalaya.com/group1/M00/1E/2F/wKgDplVMOjqAKDBIAAdd0WEpZ5c516.mp3\",\n" +
                "\t\t\t\"play_path_32\": \"http://fdfs.test.ximalaya.com/group1/M01/1D/89/wKgD3lVMOc2Acwt_AAOvX1OfH6w002.mp3\",\n" +
                "\t\t\t\"play_path_64\": \"http://fdfs.test.ximalaya.com/group1/M00/1E/2F/wKgDplVMOjqAKDBIAAdd0WEpZ5c516.mp3\",\n" +
                "\t\t\t\"play_path_aac_v164\": \"\",\n" +
                "\t\t\t\"play_path_aac_v224\": \"\",\n" +
                "\t\t\t\"created_at\": 1431058805000,\n" +
                "\t\t\t\"updated_at\": 1431058805000,\n" +
                "\t\t\t\"created_at_hour\": 22796\n" +
                "\t\t}, {\n" +
                "\t\t\t\"verify_type\": 1,\n" +
                "\t\t\t\"title\": \"黄绮珊 - 让我一次爱个够\",\n" +
                "\t\t\t\"tags\": \"儿童故事\",\n" +
                "\t\t\t\"is_v\": true,\n" +
                "\t\t\t\"duration\": 279.0,\n" +
                "\t\t\t\"uid\": 2255,\n" +
                "\t\t\t\"category_title\": \"儿童\",\n" +
                "\t\t\t\"category_id\": 6,\n" +
                "\t\t\t\"nickname\": \"tinytiny\",\n" +
                "\t\t\t\"album_id\": 74450,\n" +
                "\t\t\t\"is_paid\": false,\n" +
                "\t\t\t\"id\": 136342,\n" +
                "\t\t\t\"album_title\": null,\n" +
                "\t\t\t\"count_play\": 0,\n" +
                "\t\t\t\"count_comment\": 0,\n" +
                "\t\t\t\"count_share\": 0,\n" +
                "\t\t\t\"count_like\": 0,\n" +
                "\t\t\t\"album_cover_path\": null,\n" +
                "\t\t\t\"download_path\": \"http://fdfs.test.ximalaya.com/group1/M00/0A/12/wKgDplIAcKuAXp9aACIb6H3gCqg431.mp3\",\n" +
                "\t\t\t\"is_trailer\": 0,\n" +
                "\t\t\t\"is_trailer_bool\": false,\n" +
                "\t\t\t\"isDraft\": false,\n" +
                "\t\t\t\"upload_id\": \"u_33068\",\n" +
                "\t\t\t\"waveform\": \"group1/M00/0A/12/wKgDplIAcK2AdTVHAAAHgJiIvJI2629.js\",\n" +
                "\t\t\t\"user_source\": 1,\n" +
                "\t\t\t\"cover_path\": \"http://192.168.60.48:8080/group1/M01/0A/12/wKgDplIAcNKAYkoCAACHv3H8_sQ541.jpg!op_type=3&columns=180&rows=180\",\n" +
                "\t\t\t\"play_path\": \"http://fdfs.test.ximalaya.com/group1/M00/0A/12/wKgDplIAcKuAXp9aACIb6H3gCqg431.mp3\",\n" +
                "\t\t\t\"play_path_32\": \"http://fdfs.test.ximalaya.com/group1/M00/09/6B/wKgD3lIAcKmAAqgiABEOMhLbZd0293.mp3\",\n" +
                "\t\t\t\"play_path_64\": \"http://fdfs.test.ximalaya.com/group1/M00/0A/12/wKgDplIAcKuAXp9aACIb6H3gCqg431.mp3\",\n" +
                "\t\t\t\"play_path_aac_v164\": \"\",\n" +
                "\t\t\t\"play_path_aac_v224\": \"\",\n" +
                "\t\t\t\"created_at\": 1375760591000,\n" +
                "\t\t\t\"updated_at\": 1375760591000,\n" +
                "\t\t\t\"upload_source\": 0,\n" +
                "\t\t\t\"created_at_hour\": 7435\n" +
                "\t\t}, {\n" +
                "\t\t\t\"verify_type\": 1,\n" +
                "\t\t\t\"upload_source\": 2,\n" +
                "\t\t\t\"title\": \"Tango\",\n" +
                "\t\t\t\"tags\": \"儿童故事\",\n" +
                "\t\t\t\"is_v\": true,\n" +
                "\t\t\t\"duration\": 174.0,\n" +
                "\t\t\t\"uid\": 13001,\n" +
                "\t\t\t\"category_title\": \"儿童\",\n" +
                "\t\t\t\"category_id\": 6,\n" +
                "\t\t\t\"nickname\": \"tiny209_修改\",\n" +
                "\t\t\t\"album_id\": 85263,\n" +
                "\t\t\t\"is_paid\": false,\n" +
                "\t\t\t\"id\": 255466,\n" +
                "\t\t\t\"album_title\": \"New2015 05 08 12 08 49\",\n" +
                "\t\t\t\"count_play\": 2,\n" +
                "\t\t\t\"count_comment\": 0,\n" +
                "\t\t\t\"count_share\": 0,\n" +
                "\t\t\t\"count_like\": 0,\n" +
                "\t\t\t\"album_cover_path\": null,\n" +
                "\t\t\t\"download_path\": \"http://fdfs.test.ximalaya.com/group1/M01/1D/88/wKgD3lVMOceAQisuAAsHzVvnnUg196.aac\",\n" +
                "\t\t\t\"is_trailer\": 0,\n" +
                "\t\t\t\"is_trailer_bool\": false,\n" +
                "\t\t\t\"isDraft\": false,\n" +
                "\t\t\t\"upload_id\": \"u_134772\",\n" +
                "\t\t\t\"waveform\": \"group1/M01/1E/2F/wKgDplVMOjmAGhU_AAAGR3WM8TU3925.js\",\n" +
                "\t\t\t\"user_source\": 2,\n" +
                "\t\t\t\"cover_path\": null,\n" +
                "\t\t\t\"play_path\": \"http://fdfs.test.ximalaya.com/group1/M00/1D/88/wKgD3lVMOcWAQz7KABVCU811Ht0689.mp3\",\n" +
                "\t\t\t\"play_path_32\": \"http://fdfs.test.ximalaya.com/group1/M00/1D/89/wKgD3lVMOcqAQKG9AAqhgzudedc204.mp3\",\n" +
                "\t\t\t\"play_path_64\": \"http://fdfs.test.ximalaya.com/group1/M00/1D/88/wKgD3lVMOcWAQz7KABVCU811Ht0689.mp3\",\n" +
                "\t\t\t\"play_path_aac_v164\": \"\",\n" +
                "\t\t\t\"play_path_aac_v224\": \"\",\n" +
                "\t\t\t\"created_at\": 1431058805000,\n" +
                "\t\t\t\"updated_at\": 1431058805000,\n" +
                "\t\t\t\"created_at_hour\": 22796\n" +
                "\t\t}],\n" +
                "\t\t\"numFound\": 164,\n" +
                "\t\t\"totalPage\": 19,\n" +
                "\t\t\"start\": 0,\n" +
                "\t\t\"category\": {\n" +
                "\t\t\t\"count\": 164,\n" +
                "\t\t\t\"categoryName\": \"儿童\",\n" +
                "\t\t\t\"categoryId\": \"6\"\n" +
                "\t\t}\n" +
                "\t},\n" +
                "\t\"responseHeader\": {\n" +
                "\t\t\"QTime\": 0,\n" +
                "\t\t\"params\": {\n" +
                "\t\t\t\"q\": \"儿童故事\",\n" +
                "\t\t\t\"core\": \"track\",\n" +
                "\t\t\t\"defType\": \"edismax\",\n" +
                "\t\t\t\"indent\": \"on\",\n" +
                "\t\t\t\"qf\": \"category_title^100 title^80 tags^50 album_title^80 intro^0.001\",\n" +
                "\t\t\t\"start\": \"0\",\n" +
                "\t\t\t\"sort\": \"null desc\",\n" +
                "\t\t\t\"fq\": \"{is_paid=false, categoryId=6}\",\n" +
                "\t\t\t\"type\": \"track\",\n" +
                "\t\t\t\"searchMessage\": \"{\\\"uid\\\":0,\\\"domain\\\":\\\"1\\\",\\\"from\\\":null,\\\"time\\\":20181123155816906,\\\"keyword\\\":\\\"儿童故事\\\",\\\"uuid\\\":\\\"003ef73245b34173990d973ec1c3fa00\\\"}\",\n" +
                "\t\t\t\"rows\": \"9\",\n" +
                "\t\t\t\"wt\": \"json\"\n" +
                "\t\t},\n" +
                "\t\t\"status\": 0\n" +
                "\t}\n" +
                "}";

        TopicSearchResult result = JSON.parseObject(jsonString, new TypeReference<TopicSearchResult>() {
        });

        System.out.println(result);

        String json = JSON.toJSONString(result);
        System.out.println(json);
    }

}
