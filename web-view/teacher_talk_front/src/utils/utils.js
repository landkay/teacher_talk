'use strict';
import {Dialog} from 'vant'
window.utils = {};
(function (util) {
    /*
    * 存储localStorage
    * */
    util.setStore = function (name, content) {
        if (!name) return
        if (typeof content !== 'string') {
            content = JSON.stringify(content)
        }
        window.localStorage.setItem(name, content)
    }

    /*
    * 获取localStorage
    * */
    util.getStore = function (name) {
        if (!name) return
        return window.localStorage.getItem(name)
    }

    /*
    * 删除localStorage
    * */
    util.removeStore = function (name) {
        if (!name) return
        window.localStorage.removeItem(name)
    }

    /*
    * 判断值不为空
    * */
    util.isNotEmpty = function (data) {
        if (data === undefined || data === null || data === '') {
            return false
        }
        return true
    }

    /*
    * 判断值为空
    * */
    util.isEmpty = function (data) {
        if (data === undefined || data === null || data === '') {
            return true
        }
        return false
    }

    /*
    * 判断对象是否为空
    * */
    util.isEmptyObject = function (obj) {
        if (!obj || typeof obj !== 'object' || Array.isArray(obj))
            return false
        return !Object.keys(obj).length
    }

    /*
    * 判断小数点后是否为两位
    * */
    util.isDecimal = function (str) {
        return /^(([0-9]{1}\d*)|(0{1}))(\.\d{0,2})?$/.test(str);
    }
    /*
    * 判断邮箱格式
    * */
    util.isEmail = function (str) {
        return /\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/.test(str);
    }

    /*
    * 判断身份证格式
    * */
    util.isIdCard = function (str) {
        return /^(^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$)|(^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])((\d{4})|\d{3}[Xx])$)$/.test(str)
    }

    /*
    * 判断手机号格式
    * */
    util.isPhoneNum = function (str) {
        return /^1[3-9]\d{9}$|^(853|852)\d{8}$|^886\d{10}$|^(00853|00852)\d{8}$|^00886\d{10}$/.test(str)
    }

    /*
   * 判断是否是纯数字
   * */
    util.isNum = function (str) {
        return /^\d*$/.test(str)
    }

    /**
     * 浮点型加法
     * @param str
     * @returns {boolean}
     */
    util.numberAdd = function (arg1, arg2) {
        let r1, r2, m, n
        try {
            r1 = arg1.toString().split(".")[1].length
        } catch (e) {
            r1 = 0
        }
        try {
            r2 = arg2.toString().split(".")[1].length
        } catch (e) {
            r2 = 0
        }
        m = Math.pow(10, Math.max(r1, r2))
        n = (r1 >= r2) ? r1 : r2
        return ((arg1 * m + arg2 * m) / m).toFixed(n)
    }

    /**
     * 加法运算
     * @param num1
     * @param num2
     * @returns {number|*}
     */
    utils.accAdd = function(num1, num2) {
        num1 = Number(num1);
        num2 = Number(num2);
        let dec1, dec2, times;
        try { dec1 = util.countDecimals(num1)+1; } catch (e) { dec1 = 0; }
        try { dec2 = util.countDecimals(num2)+1; } catch (e) { dec2 = 0; }
        times = Math.pow(10, Math.max(dec1, dec2));
        // let result = (num1 * times + num2 * times) / times;
        let result = (util.accMul(num1, times) + util.accMul(num2, times)) / times;
        return util.getCorrectResult("add", num1, num2, result);
        // return result;
    };

    /**
     * 减法运算
     * @param num1
     * @param num2
     * @returns {number|*}
     */
    util.accSub = function(num1, num2) {
        num1 = Number(num1);
        num2 = Number(num2);
        let dec1, dec2, times;
        try { dec1 = util.countDecimals(num1)+1; } catch (e) { dec1 = 0; }
        try { dec2 = util.countDecimals(num2)+1; } catch (e) { dec2 = 0; }
        times = Math.pow(10, Math.max(dec1, dec2));
        // let result = Number(((num1 * times - num2 * times) / times);
        let result = Number((util.accMul(num1, times) - util.accMul(num2, times)) / times);
        return util.getCorrectResult("sub", num1, num2, result);
        // return result;
    };

    /**
     * 除法运算
     * @param num1
     * @param num2
     * @returns {number|*}
     */
    utils.accDiv = function(num1, num2) {
        num1 = Number(num1);
        num2 = Number(num2);
        let t1 = 0, t2 = 0, dec1, dec2;
        try { t1 = util.countDecimals(num1); } catch (e) { }
        try { t2 = util.countDecimals(num2); } catch (e) { }
        dec1 = util.convertToInt(num1);
        dec2 = util.convertToInt(num2);
        let result = util.accMul((dec1 / dec2), Math.pow(10, t2 - t1));
        return util.getCorrectResult("div", num1, num2, result);
        // return result;
    };

    /**
     * 乘法运算
     * @param num1
     * @param num2
     * @returns {number|*}
     */
    util.accMul = function(num1, num2) {
        num1 = Number(num1);
        num2 = Number(num2);
        let times = 0, s1 = num1.toString(), s2 = num2.toString();
        try { times += util.countDecimals(s1); } catch (e) { }
        try { times += util.countDecimals(s2); } catch (e) { }
        let result = util.convertToInt(s1) * util.convertToInt(s2) / Math.pow(10, times);
        return util.getCorrectResult("mul", num1, num2, result);
        // return result;
    };

    /**
     * 计算小数位的长度
     * @param num
     * @returns {number}
     */
    util.countDecimals = function(num) {
        let len = 0;
        try {
            num = Number(num);
            let str = num.toString().toUpperCase();
            if (str.split('E').length === 2) { // scientific notation
                let isDecimal = false;
                if (str.split('.').length === 2) {
                    str = str.split('.')[1];
                    if (parseInt(str.split('E')[0]) !== 0) {
                        isDecimal = true;
                    }
                }
                let x = str.split('E');
                if (isDecimal) {
                    len = x[0].length;
                }
                len -= parseInt(x[1]);
            } else if (str.split('.').length === 2) { // decimal
                if (parseInt(str.split('.')[1]) !== 0) {
                    len = str.split('.')[1].length;
                }
            }
        } catch(e) {
            throw e;
        } finally {
            if (isNaN(len) || len < 0) {
                len = 0;
            }
            return len;
        }
    };

    /**
     * 将小数转成整数
     * @param num
     * @returns {number}
     */
    util.convertToInt = function(num) {
        num = Number(num);
        let newNum = num;
        let times = util.countDecimals(num);
        let temp_num = num.toString().toUpperCase();
        if (temp_num.split('E').length === 2) {
            newNum = Math.round(num * Math.pow(10, times));
        } else {
            newNum = Number(temp_num.replace(".", ""));
        }
        return newNum;
    };

    /**
     * 确认计算结果
     * @param type
     * @param num1
     * @param num2
     * @param result
     * @returns {number|*}
     */
    util.getCorrectResult = function(type, num1, num2, result) {
        let temp_result = 0;
        switch (type) {
            case "add":
                temp_result = num1 + num2;
                break;
            case "sub":
                temp_result = num1 - num2;
                break;
            case "div":
                temp_result = num1 / num2;
                break;
            case "mul":
                temp_result = num1 * num2;
                break;
        }
        if (Math.abs(result - temp_result) > 1) {
            return temp_result;
        }
        return result;
    };

    /**
     * 判断银行卡号
     * @param str
     */
    util.isBankNum = function (str) {
        return /^\d{8,}$/.test(str)
    }

    /**
     * 返回字符串字节大小 把任何非ASCII编码的字符替换成"01"两位字符 * @param str * @returns
     */
    util.getBLen = function (str) {
        return str.replace(/[^\x00-\xff]/g, "01").length
    }

    /*
    * 保留n位小数
    * */
    util.toDecimal = function (num, count= 2) {
        num = num.toString()
        num.includes('.') ? num = num + '0000000000' : num = num + '.0000000000'
        num = num.replace(eval('/^(.*\\..{' + (count + 1) + '}).*$/'), '$1')
        let multiple = 1 + Array(count + 1).join(0)
        return Math.round(num * multiple) / multiple
    }

    /*
    * base64转blob
    * */
    util.dataURLtoBlob = function (dataURL) {
        let arr = dataURL.split(',')
        let mime = arr[0].match(/:(.*?);/)[1]
        let bstr = atob(arr[1]);
        let n = bstr.length;
        let u8arr = new Uint8Array(n)
        while (n--) {
            u8arr[n] = bstr.charCodeAt(n)
        }
        return new Blob([u8arr], { type: mime })
    }

    /*
    * blob转base64
    * */
    util.blobToDataURL = function (blob) {
        return new Promise((resolve, reject) => {
            let reader = new FileReader()
            reader.readAsDataURL(blob)
            reader.onload = () => {
                resolve(reader.result)
            }
            reader.onerror = (err) => {
                reject(err)
            }
        })
    }

    /*
    * 时间格式化
    * */
    util.formatTime = function (value, format) {
        let nowDate = new Date(value)
        let weeks = ['日', '一', '二', '三', '四', '五', '六']
        let time = (new Date(+nowDate + 8 * 3600 * 1000)).toISOString().substr(0, 19).replace(/[a-z]/i, ' ');
        let [_, YYYY, MM, DD, hh, mm, ss] = /(\d{4})-(\d{2})-(\d{2}) (\d{2}):(\d{2}):(\d{2})/g.exec(time)
        let filterTime = (type, _) => type.slice(0, _.length)
        return format.replace(/(Y{1,4})/g, ($1) => filterTime(YYYY, $1))
            .replace(/(M{1,2})/g, ($1) => filterTime(MM, $1))
            .replace(/(D{1,2})/g, ($1) => filterTime(DD, $1))
            .replace(/(h{1,2})/g, ($1) => filterTime(hh, $1))
            .replace(/(m{1,2})/g, ($1) => filterTime(mm, $1))
            .replace(/(s{1,2})/g, ($1) => filterTime(ss, $1))
            .replace(/(W{1})/g, ($1) => weeks[nowDate.getDay()])
            .replace(/(Q{1})/g, ($1) => Math.floor((nowDate.getMonth() + 3) / 3))
    }

    /**
     *  毫秒转时间
     * @param time
     * @returns {string}
     */
    util.changeTime = function (time) {
        let commonTime = ""
        if (time) {
         let unixTimestamp = new Date(time*1);
         commonTime = unixTimestamp.toLocaleString();
        }
        return commonTime;
    }

    /*
    * url参数转对象
    * */
    util.parseQueryString = function (url) {
        url = !url ? window.location.href : url
        if (url.indexOf('?') === -1) return {}
        let search = url[0] === '?' ? url.substr(1) : url.substring(url.lastIndexOf('?') + 1)
        if (search === '') return {}
        search = search.split('&')
        let query = {}
        for (let i = 0; i < search.length; i++) {
            let pair = search[i].split('=')
            query[decodeURIComponent(pair[0])] = decodeURIComponent(pair[1] || '')
        }
        return query
    }
    /*
    * 函数防抖
    * */
    util.debounce = function (fn, delay, immediate = false) {
        let timer = null;
        let status = true;
        if (!immediate) return function () {
            let args = arguments;
            if (timer) clearTimeout(timer)
            timer = setTimeout(() => fn.apply(this, args), delay)
        }
        else return function () {
            clearTimeout(timer);
            if (status) {
                status = false;
                fn.call(this, arguments);
            } else {
                Dialog.alert({
                    title: '提示',
                    message: `请勿重复操作，请2秒之后再试`,
                    confirmButtonColor: '#CC0000'
                })
            }
            timer = setTimeout(() => status = true, delay);
        }
    }

    /*
    * 函数节流
    * */
    util.throttle = function (fn, delay) {
        let timer = null;
        return function () {
            let args = arguments;
            if (!timer) {
                timer = setTimeout(() => {
                    timer = null;
                    fn.apply(this, args)
                }, delay)
            }
        }
    }

    /*
    * 根据生日获取年龄
    * */
    util.getAge = function (str) {
        let date = +new Date(str)
        return ~~((Date.now() - date) / 31557800000)
    }

    /*
    * guid
    * */
    util.guid = function () {
        return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function (c) {
            let r = Math.random() * 16 | 0,
                v = c == 'x' ? r : (r & 0x3 | 0x8)
            return v.toString(16)
        })
    }

    /**
     * 对身份证的校验
     */
        //15位和18位身份证号码的基本校验
    const simpoleCheck = /^((\d{15})|(\d{17}(\d|x|X)))$/;
    /*
     * 15位身份证正则  证件格式 xxxxxx yymmdd xxx
     * 1.1 地址码长6位 以数字1-9开头  后5位为0-9的数字
     * 1.2 年份码长2位 两位为0-9的数字
     * 1.3 月份码长2位 第一位数字为0，第二位数字为1-9或者第一位数字为1，第二位数字为0-2
     * 1.4 日期码长2位 第一位数字为0-2，第二位数字为1-9或者是10，20，30，31
     * 1.5 顺序码长3位 顺序码是数字 第15位 奇数为男 偶数为女 15位身份证不含X
     */
    const IdCardNo_15 = /^[1-9]\d{7}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\d{3}$/;
    /*
     * 18位身份证正则 证件格式 xxxxxx yyyymmdd xxx p
     * 1.1 地址码长6位 以数字1-9开头  后5位为0-9的数字
     * 1.2 年份码长4位 以数字19或20开头 剩余两位为0-9的数字
     * 1.3 月份码长2位 第一位数字为0，第二位数字为1-9或者第一位数字为1，第二位数字为0-2
     * 1.4 日期码长2位 第一位数字为0-2，第二位数字为1-9或者是10，20，30，31
     * 1.5 顺序码长3位 顺序码是数字 第17位 奇数为男 偶数为女
     * 1.6 校验码长1位 可以是数字，字母x或字母X
     *
     */
    // const IdCardNo_18 = /^[1-9]\d{5}(19|20)\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\d{3}[\dXx]$/;
    const IdCardNo_18 = /^(^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$)|(^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])((\d{4})|\d{3}[Xx])$)$/;
    //身份证省级编码
    const IdCardProvinceCode = "11,12,13,14,15,21,22,23,31,32,33,34,35,36,37,41,42,43,44,45,46,50,51,52,53,54,61,62,63,64,65,71,81,82,91";

    /**
     * 校验证件类型 01|02|04|05|06|07|09|99
     * 保单服务
     * 证件号码中不能包含以下特殊字符：*?!&¥$%^#,/@";:><][}{-=+_\∣》《。，、？’‘“”~`
     * 不能有回车符。
     * 编号位数：
     * 编号校验：
     * 	军官证，士兵证
     *  护照、出生证明、其他
     *  港澳居民来往大陆通行证
     *  台湾居民来往大陆通行证
     *	外国人永久居留证
     *
     * @param {Object} idCard 证件号码
     * @param {Object} idType 证件类型
     */
    util.checkCFType = function (idCard, idType, birthDay, sex) {
        let flag = true;
        if (idType == "01" || idType == "02") {//军官证，士兵证
            //10到18个字符，并且必须同时包含中文和数字
            //let rule = /^(?=.*[\u4e00-\u9fa5])(?=.*[0-9])[^]{10,18}$/;
            //中文+数字格式 其中中文为1到4个，数字为7到10个 （必须是中文在前，数字在后，不能交叉）
            let rule = /^[\u4e00-\u9fa5]{1,4}([0-9]{7,10})$/;
            if (!rule.test(idCard)) {
                flag = false;
            }
        } else if (idType == "06" || idType == "07" || idType == "99") {//护照、出生证明、其他
            //3个及以上字符
            let rule = /^[\s\S]{3}/;
            if (!rule.test(idCard)) {
                flag = false;
            }
        } else if (idType == "04") {//港澳居民来往大陆通行证
            //1位字母（H或M）+8位数字+2位数字 或 1位字母（H或M）+8位数字
            let rule = /^[HM](?:\d{8}|\d{10})$/;
            if (!rule.test(idCard)) {
                flag = false;
            }

        } else if (idType == "05") {//台湾居民来往大陆通行证
            //8位数字 或 8位数字+2位数字
            let rule = /^(?:\d{8}|\d{10})$/;
            if (!rule.test(idCard)) {
                flag = false;
            }
        } else if (idType == "09") {//外国人永久居留证
            //15个字符（前三位字母+12位数字）
            let rule = /^[A-Z]{3}\d{12}$/;
            if (!rule.test(idCard)) {
                flag = false;
            }
            //生日校验
            if (birthDay == null) {
                flag = false;
            } else {
                let numberBirthDay = birthDay.replace(/-/g, "");
                let idBirtherDay = idCard.substring(7, 13);
                if (numberBirthDay != idBirtherDay) {
                    flag = false;
                }
            }

        } else if (idType == "00" || idType == "08" || idType == "08") {//身份证 户口本 临时身份证
            let rule = IdCardNo_18;
            if (!rule.test(idCard)) {
                flag = false;
            }
            //身份证省级编码
            let IdCardProvinceCodeRule = IdCardProvinceCode;
            if (IdCardProvinceCodeRule.indexOf(idCard.substring(0, 2)) < 0) {
                flag = false;
            }
            //生日校验
            if (birthDay == null) {
                flag = false;
            } else {
                let numberBirthDay = birthDay.replace(/-/g, "");
                let idBirtherDay = idCard.substring(6, 14);
                if (numberBirthDay != idBirtherDay) {
                    flag = false;
                }
            }
            //性别校验
            if (sex == null) {
                flag = false;
            } else {
                let sexManOrFemale = null;
                let sexVal = parseInt(idCard.substring(16, 17))
                sexVal % 2 == 0 ? sexManOrFemale = "F" : sexManOrFemale = "M"
                sexManOrFemale == sex ? flag : flag = false;
            }
            //验证校验码
            let idCode = idCard.substring(17);
            let id17 = idCard.substring(0, 17);
            //加权
            let factor = [7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2];
            let parity = [1, 0, 'X', 9, 8, 7, 6, 5, 4, 3, 2];
            let sum = 0;
            for (let i = 0; i < 17; i++) {
                sum += parseInt(id17.charAt(i), 10) * parseInt(factor[i], 10);
            }
            if (parity[sum % 11] != idCode.toUpperCase()) {
                flag = false
            }
        }
        return flag;
    }
    //判断not empty
    util.checkIsEmpty=function(data) {
        if (data !== 'undefined' && data !== '' && data !== null) {
            return true
        } else {
            return false
        }
    }

    /**
     * 根据出生日期获取当前年龄
     * 出生日期月份大于当前月 按年份在减一算
     * 出生日期月份小于当前月 按年份算
     * 出生日期月份等于当前月 判断 出生日期日 小于等于 当前日 按年份算
     * 出生日期月份等于当前月 判断 出生日期日 大于 当前日 按年份在减一算
     */
    util.getBirthdayAge=function(brith) {
        let age = "";
        brith = brith.replace(/-/g, "");
        let brithYear = parseInt(brith.substring(0, 4), 10);
        let brithMonth = parseInt(brith.substring(4, 6), 10);
        let brithDay = parseInt(brith.substring(6), 10);
        let newDate = new Date();
        let newYear = newDate.getFullYear();
        let newMonth = newDate.getMonth() + 1;//当前月
        let newDay = newDate.getDate();
        if (brithMonth > newMonth) {
            age = newYear - brithYear - 1;
        } else if (brithMonth < newMonth) {
            age = newYear - brithYear;
        } else {
            if (brithDay <= newDay) {
                age = newYear - brithYear;
            } else {
                age = newYear - brithYear - 1;
            }
        }
        return age;
    }
    /**
     * 国籍限制证件类型选择
     * isNull 是否允许空值
     */
    utils.validateNationality=function(data, isNull) {
        if (!data.countrySelect || !data.countrySelect.regioncode || data.countrySelect.regioncode == "0") {
            //空值的时候不校验国籍
            if (isNull == true || isNull == "true") {
                return true;
            }
            {
                //showwinAuto(data.nationalityMsg);
                return false;
            }
        }

        if (data.certtype && data.certtype == "99") {
            //刚和需求核对了下，由于没有设置证件类型为“其他”时的校验规则，因此证件类型为其他时，不校验国籍，请修改。
            return true;
        }

        //指定国籍不能使用的证件类型
        let _tempPoint = {
            'CHN': ['06', '09'],
            'HKG': ['00', '01', '02', '03', '05', '06', '08', '09', '11'],
            'MAC': ['00', '01', '02', '03', '05', '06', '08', '09', '11'],
            'TWN': ['00', '01', '02', '03', '04', '06', '08', '09', '10']
        };

        let _strT = '';
        switch (data.countrySelect.regioncode) {
            case '156':
                _strT = 'CHN';
                break;
            case '446':
                _strT = 'MAC';
                break;
            case '158':
                _strT = 'TWN';
                break;
            case '344':
                _strT = 'HKG';
                break;
            default:
                break;
        }
        //如果选择的是 中国， 台湾，香港，澳门
        if (_tempPoint[_strT]) {
            //如果选择的证件类型包含不可用
            if (_tempPoint[_strT].indexOf(data.certtype) > -1) {
                //showwinAuto(data.nationalityMsg);
//          showwinAuto(data.countrySelect.regionname + '的地区不能使用此证件类型');
                return false
            }
        } else {
            //除大陆港澳台以外 ，如果
            if (['06', '07', '09'].indexOf(data.certtype) === -1) {
                //showwinAuto(data.nationalityMsg);
//          showwinAuto(data.countrySelect.regionname + '的地区不能使用此证件类型');
                return false
            }
        }
        return true;
    }
})(window.utils)

