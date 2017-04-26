/**
 * Created by wangminglei on 2015-4-2.
 */

var ERROR_CODES ={
    //register
    '100001':'应用认证失败',
    '100003':'注册成功登陆失败',
    '100005':'该手机号已被注册过',
    '100006':'验证码错误',
    '100007':'该手机号已被注册过',
    '201079':'手机验证码错误',
    '201077':'请重新获取验证码',
    '216003':'该手机号已被注册过',
    //signon
    '216006':'登录失败',
    '216007':'用户名不存在', //登录失败（用户不存在）
    '216008':'密码错误',
    '216040':'用户名或密码错误',
    '201058':'手机号无效请重新输入',

    '216009':'设备无效',
    '216010':'应用认证失败',

    '100015':'验证码错误',
    '100040':'手机号未注册',
    '100041':'操作频繁，请一分钟后再尝试',
    '201015':'密码找回用户名与email不匹配',
    '201023':'手机号不符合格式要求',
    '201076':'操作频繁，请一分钟后再尝试',
    '999999':'服务器遇到问题,请稍后重试',
    '200024':'图片验证码错误',
    '200023':'图片验证码过期',
    '330':'TV端已有账号登录，退出当前账号，可切换登录新账号',
    '210006':'请先在电视端登录，再继续'
}
window.localStorage['errCodes']=JSON.stringify(ERROR_CODES);


