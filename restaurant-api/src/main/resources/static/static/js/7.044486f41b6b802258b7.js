webpackJsonp([7],{"/xyw":function(t,e){},"T+/8":function(t,e,o){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var i=o("4OJU"),n=o("hNpR"),r=o.n(n),a={name:"login",data:function(){return{loginForm:{userName:"",password:"",attribute:""},loginRules:{username:[{required:!0,trigger:"blur",validator:function(t,e,o){["admin","test"].indexOf(e)>=0?o():o(new Error("请输入正确的用户名"))}}],password:[{required:!0,trigger:"blur",validator:function(t,e,o){e.length<6||e.length>15?o(new Error("密码不能小于6位,大于15位")):o()}}],attribute:[{required:!0}]},attribute:1,loading:!1,pwdType:"password",login_center_bg:r.a,dialogVisible:!1,supportDialogVisible:!1}},created:function(){this.loginForm.attribute=1,void 0!==this.loginForm.password&&null!=this.loginForm.password||(this.loginForm.password="")},methods:{showPwd:function(){"password"===this.pwdType?this.pwdType="":this.pwdType="password"},handleLogin:function(){var t=this;this.$refs.loginForm.validate(function(e){if(!e)return console.log("参数验证不合法！"),!1;t.loading=!0,t.$store.dispatch("Login",t.loginForm).then(function(){t.loading=!1,Object(i.b)("username",t.loginForm.username,15),Object(i.b)("attribute",t.loginForm.attribute,15),t.$router.push({path:"/"})}).catch(function(){t.loading=!1})})},handleTry:function(){this.dialogVisible=!0},dialogConfirm:function(){this.dialogVisible=!1,Object(i.c)(!0)},dialogCancel:function(){this.dialogVisible=!1,Object(i.c)(!1)}}},l={render:function(){var t=this,e=t.$createElement,o=t._self._c||e;return o("div",[o("el-card",{staticClass:"login-form-layout"},[o("el-form",{ref:"loginForm",attrs:{autoComplete:"on",model:t.loginForm,rules:t.loginRules,"label-position":"left"}},[o("div",{staticStyle:{"text-align":"center"}},[o("svg-icon",{staticStyle:{width:"56px",height:"56px",color:"#409EFF"},attrs:{"icon-class":"login-mall"}})],1),t._v(" "),o("h2",{staticClass:"login-title color-main"},[t._v("码上吃饭")]),t._v(" "),o("el-form-item",{attrs:{prop:"username"}},[o("el-input",{attrs:{name:"username",type:"text",autoComplete:"on",placeholder:"请输入用户名"},model:{value:t.loginForm.username,callback:function(e){t.$set(t.loginForm,"username",e)},expression:"loginForm.username"}},[o("span",{attrs:{slot:"prefix"},slot:"prefix"},[o("svg-icon",{staticClass:"color-main",attrs:{"icon-class":"user"}})],1)])],1),t._v(" "),o("el-form-item",{attrs:{prop:"password"}},[o("el-input",{attrs:{name:"password",type:t.pwdType,autoComplete:"on",placeholder:"请输入密码"},nativeOn:{keyup:function(e){return"button"in e||!t._k(e.keyCode,"enter",13,e.key,"Enter")?t.handleLogin(e):null}},model:{value:t.loginForm.password,callback:function(e){t.$set(t.loginForm,"password",e)},expression:"loginForm.password"}},[o("span",{attrs:{slot:"prefix"},slot:"prefix"},[o("svg-icon",{staticClass:"color-main",attrs:{"icon-class":"password"}})],1),t._v(" "),o("span",{attrs:{slot:"suffix"},on:{click:t.showPwd},slot:"suffix"},[o("svg-icon",{staticClass:"color-main",attrs:{"icon-class":"eye"}})],1)])],1),t._v(" "),o("el-form-item",{attrs:{prop:"attribute"}},[o("el-row",[o("el-col",{attrs:{span:2}},[o("div",{staticClass:"grid-content bg-purple-dark"})]),t._v(" "),o("el-col",{attrs:{span:20}},[o("div",[o("el-radio-group",{model:{value:t.loginForm.attribute,callback:function(e){t.$set(t.loginForm,"attribute",e)},expression:"loginForm.attribute"}},[o("el-radio",{attrs:{label:1}},[t._v("管理员")]),t._v(" "),o("el-radio",{attrs:{label:2}},[t._v("后厨")]),t._v(" "),o("el-radio",{attrs:{label:3}},[t._v("收银员")])],1)],1)])],1)],1),t._v(" "),o("el-form-item",{staticStyle:{"margin-bottom":"60px","text-align":"center"}},[o("el-button",{staticStyle:{width:"45%"},attrs:{type:"primary",loading:t.loading},nativeOn:{click:function(e){return e.preventDefault(),t.handleLogin(e)}}},[t._v("\n          登录\n        ")])],1)],1)],1),t._v(" "),o("img",{staticClass:"login-center-layout",attrs:{src:t.login_center_bg}})],1)},staticRenderFns:[]};var s=o("VU/8")(a,l,!1,function(t){o("/xyw")},"data-v-3b9699df",null);e.default=s.exports},hNpR:function(t,e,o){t.exports=o.p+"static/img/login_center_bg.5307896.png"}});
//# sourceMappingURL=7.044486f41b6b802258b7.js.map