(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-e2d7a9f8"],{2450:function(t,i,s){"use strict";s.r(i);var e=function(){var t=this,i=t.$createElement,s=t._self._c||i;return s("div",{staticClass:"option-cnt",style:t.backgroundDiv},[s("div",{staticClass:"login-cnt"},[s("div",{staticClass:"login-item",on:{click:function(i){return t.clickOption("user")}}},[t._v("普通用户")]),s("div",{staticClass:"login-item",on:{click:function(i){return t.clickOption("musician")}}},[t._v("音乐人")]),s("div",{staticClass:"login-item",on:{click:function(i){return t.clickOption("company")}}},[t._v("企业")])]),s("el-dialog",{attrs:{title:t.dialogTitle,visible:t.loginVisible,width:"30%",center:"","append-to-body":""},on:{"update:visible":function(i){t.loginVisible=i}}},[s("div",{staticClass:"ld-value"},[s("div",{staticClass:"label"},[t._v("私钥：")]),s("el-input",{staticClass:"myinput",attrs:{placeholder:"请输入私钥"},model:{value:t.pwd,callback:function(i){t.pwd=i},expression:"pwd"}})],1),s("div",{staticClass:"ld-register",on:{click:t.switchToRegister}},[t._v("点此注册")]),s("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[s("el-button",{attrs:{type:"primary"},on:{click:t.clickLogin}},[t._v("登 录")])],1)]),s("el-dialog",{attrs:{title:"用户注册",visible:t.registerVisible,width:"30%",center:"","append-to-body":""},on:{"update:visible":function(i){t.registerVisible=i}}},[s("div",{staticClass:"register-box"},[s("div",{staticClass:"reg-line"},[s("div",{staticClass:"label"},[t._v("姓名：")]),s("el-input",{staticClass:"myinput",attrs:{placeholder:"请输入姓名"},model:{value:t.name,callback:function(i){t.name=i},expression:"name"}})],1),s("div",{staticClass:"reg-line",staticStyle:{"margin-top":"30px"}},[s("div",{staticClass:"label"},[t._v("电话号码：")]),s("el-input",{staticClass:"myinput",attrs:{placeholder:"请输入电话号码"},model:{value:t.phone,callback:function(i){t.phone=i},expression:"phone"}})],1)]),s("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[s("el-button",{attrs:{type:"primary"},on:{click:t.clickRegister}},[t._v("注 册")])],1)]),s("el-dialog",{attrs:{title:"用户信息",visible:t.showVisible,width:"30%",center:"","append-to-body":""},on:{"update:visible":function(i){t.showVisible=i}}},[s("div",{staticClass:"register-box"},[s("div",{staticClass:"reg-line"},[s("span",{staticClass:"label"},[t._v("地址：")]),s("span",[t._v(t._s(t.show_address))])]),s("div",{staticClass:"reg-line",staticStyle:{"margin-top":"30px"}},[s("div",{staticClass:"label"},[t._v("私钥：")]),s("span",[t._v(t._s(t.show_key))])])]),s("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[s("el-button",{attrs:{type:"primary"},on:{click:function(i){t.showVisible=!1}}},[t._v("确 定")])],1)])],1)},a=[],o=(s("7f7f"),{data:function(){return{loginVisible:!1,registerVisible:!1,showVisible:!1,pwd:"",name:"",phone:"",type:"user",backgroundDiv:{backgroundImage:"url("+s("6a07")+")"},show_address:"",show_key:""}},computed:{dialogTitle:function(){return"musician"===this.type?"音乐人登录":"company"===this.type?"企业登录":"用户登录"}},methods:{clickOption:function(t){this.type=t,this.loginVisible=!0},switchToRegister:function(){this.loginVisible=!1,"musician"===this.type?this.$router.push("/musician"):"company"===this.type?this.$router.push("/company"):this.registerVisible=!0},clickLogin:function(){var t=this;this.loginVisible=!1,this.axios.post("/api/login",{privateKey:this.pwd}).then(function(i){if(i=i.data,0===i.success)t.$message.error("私钥错误");else{var s=i.data;console.log(s),t.$store.commit("initSetState",{privateKey:t.pwd,userType:s.type,isLogin:!0}),t.$store.commit("setUser",s),t.$router.push("/center/info"),t.$message.success("登录成功")}}).catch(function(i){t.$message.error("私钥错误")})},clickRegister:function(){var t=this;this.registerVisible=!1,this.axios.post("/api/register",{name:this.name,phone:this.phone}).then(function(i){0===i.data.success?t.$message.error("注册失败"):(t.$message.success("注册成功"),t.show_address=i.data.data[0],t.show_key=i.data.data[1],t.showVisible=!0)}).catch(function(t){console.log(t)})}}}),l=o,n=(s("bdbe"),s("2877")),c=Object(n["a"])(l,e,a,!1,null,"989c4b5c",null);i["default"]=c.exports},bdbe:function(t,i,s){"use strict";var e=s("f1f8"),a=s.n(e);a.a},f1f8:function(t,i,s){}}]);
//# sourceMappingURL=chunk-e2d7a9f8.b41ef5f3.js.map