<template>
  <div class="page" id="page" @click="clickTips">
      <div class="wrapper">
        <el-row>
            <el-col :xs="24" :sm="4" :md="18" :lg="18" :xl="18">
              <div class="main">
                <p class="title">About</p>
                <!-- <list_article :items="items" type="archives"></list_article> -->
                <div class="card">
                  <p class="card-title" id="anchor-about">about me</p>
                  <p class="txt"></p>
                  <p class="txt"></p>
                  <p class="txt"></p>
                </div>
                <div class="card">
                  <p class="card-title" id="anchor-contact"></p>
                  <ul>
                    <li><a href="" target="_blank"></a></li>
                    <li><a href="" target="_blank"></a></li>
                    <li><a href="" target="_blank"></a></li>
                    <li><a href="" target="_blank"></a></li>
                    <li> <a href=""></a></li>
                    <li></li>
                  </ul>
                </div>
                <div class="card">
                  <p class="card-title" id="anchor-us">context</p>
                  <p class="txt"></p>
                  <p class="txt"></p>
                  <p class="txt"></p>
                  <ul>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                  </ul>
                  <div class="update">
                    <h3 id="update-log">us</h3>
                    <p></p>
                    <ul>
                      <li> </li>
                    </ul>
                    <ul>
                      <li></li>
                      <li></li>
                      <li></li>
                      <li></li>
                    </ul>
                    <ul>
      <li></li>
                      <li></li>
                      <li></li>
                      <li></li>
                    </ul>
                    <ul>
      <li></li>
                      <li></li>
                      <li></li>
                      <li></li>
                    </ul>
                  </div>
                </div>
                <div class="card">
                  <p class="card-title" id="anchor-friend">fried</p>
                  <div class="row-link">
                    <a class="link" href="" target="_blank">1</a>|
                    <a class="link" href="" target="_blank">2</a>|
                    <a class="link" href="" target="_blank">Blog</a>|
                    <a class="link" href="" target="_blank">Blog</a>|
                    <a class="link" href="" target="_blank">Blog</a>|
                    <a class="link" href="" target="_blank">Blog</a>
                  </div>
                </div>
              </div>
            </el-col>
            <el-col :xs="0" :sm="4" :md="6" :lg="6" :xl="6">
              <div class="aside">
                <p class="title">Content</p>
                <!-- <list_content :items="items"></list_content> -->
                  <div class="content">
                    <ul>
                      <li><a href="javascript:;" class="title" @click="anchor('about')">about me</a></li>
                      <li><a href="javascript:;" class="title" @click="anchor('contact')">contaxt</a></li>
                      <li><a href="javascript:;" class="title" @click="anchor('us')">us</a></li>
                      <li><a href="javascript:;" class="title" @click="anchor('friend')">friend</a></li>
                    </ul>
                  </div>
              </div>
            </el-col>
        </el-row>
      </div>
  </div>
</template>

<script>
import { anchor } from "../../static/js/public.js";


export default {
  mixins: [anchor]
};
</script>

<style lang="scss" scoped>
.main {
  background: #f8f8fd;
  box-shadow: 0 1px 2px rgba(0, 0, 0, 0.4), 0 0 30px rgba(10, 10, 0, 0.1) inset;
  margin: 0 10px;
  padding: 10px;
  > .title {
    font-size: 18px;
    padding: 5px 0;
  }
  .card {
    border-top: 1px solid #eee;
    .card-title {
      margin: 20px 0 10px;
      font-size: 26px;
    }
    .txt {
      font-size: 16px;
      margin: 0 20px 10px;
    }
    > ul {
      padding: 20px 30px;
      > li {
        padding: 10px 0;
      }
    }
    a {
      color: #4d6dad;
      &:hover {
        color: #223253;
        background-color: #f4efeb;
      }
    }
    .update {
      padding: 20px;
      h3 {
        margin: 0;
      }
      > p {
        margin: 10px;
      }
      > ul {
        padding: 0 30px;
      }
    }
    .row-link {
      padding: 20px;
      .link {
        margin: 5px;
        &:hover {
          color: #0085a1;
        }
      }
    }
  }
}
.aside {
  background: #f8f8fd;
  box-shadow: 0 1px 2px rgba(0, 0, 0, 0.4), 0 0 30px rgba(10, 10, 0, 0.1) inset;
  > .title {
    font-size: 16px;
    font-weight: 600;
    border-bottom: 1px solid #ddd;
    padding: 10px 15px;
  }
  .content {
    padding: 15px 30px;
    li {
      list-style-type: none;
      padding: 5px 16px;
      position: relative;
      &::before {
        content: "";
        width: 6px;
        height: 6px;
        background: #333;
        position: absolute;
        left: 0;
        top: 13px;
        border-radius: 50%;
      }
      > a {
        color: #4d6dad;
        &:hover {
          color: #223253;
        }
      }
    }
  }
}

@media (min-width: 768px) {
  //pc
  .main {
    margin: 0 20px;
    padding: 20px;
    > .title {
      font-size: 30px;
    }
  }
}
</style>
<style>
@keyframes click_translateTop {
  0%,
  100% {
    opacity: 0;
  }
  10% {
    opacity: 1;
  }
  100% {
    transform: translateY(-30px);
  }
}
</style>

