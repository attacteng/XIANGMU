<template>
	<view>
		<view class="flex justify-between padding">
			<view class="" @click="handleSend">
				草莓蛋糕
			</view>
			<view class="">
				购物车按钮{{num}}
			</view>
		</view>
		<test-my-comp name="张三丰" @onNum="handleNum"></test-my-comp>
	</view>
</template>

<script>
	import testBus from '../../bus/testBus.js'
	export default {
		data() {
			return {
				num:100
			}
		},
		methods: {
			handleNum(n){
				console.log(n);
				this.num += n
			},
			handleSend(){
				testBus.$emit('sendData',{ //向bus发送消息
					msg:'hello',
					num:123
				})
			}
		}
	}
</script>

<style lang="scss">
// @import '../../colorui/main.css';
// @import '../../colorui/main.css';
</style>
