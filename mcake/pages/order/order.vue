<template>
	<view>
		<view @click="handleAddress" class="padding flex align-center justify-between">
			<view class="" v-if="orderAddress">
				{{orderAddress.username}},{{orderAddress.phone}}
				<view class="">
					{{orderAddress.city}}
					{{orderAddress.region}}
					{{orderAddress.detail}}
				</view>
			</view>
			<view class="" v-else>
				请选择地址
			</view>
			<text class="cuIcon-right"></text>
		</view>
		<view class="padding">
			配送时间
		</view>
		<view class="padding flex justify-between">
			<view class="">
				请选择配送日期
			</view>
			<view class="">
				请选择配送时间
			</view>
		</view>
		<view class="flex padding">
			<view class="flex align-center">
				<image class="poster margin-right" src="" mode=""></image>
			</view>
			<view class="flex justify-between info">
				<view class="">
					蓝莓蛋糕
					<view class="margin-tb-xs">LanMEi</view>
					￥199
				</view>
				<view class="flex flex-direction align-end">
					<view class="edit margin-bottom-xs">
						<text class="iconfont icon-bianji"></text>
					</view>
					<!-- {{item.list[item.idx].spec}} -->
					 X 
					<!-- {{item.num}} -->
				</view>
			</view>
		</view>
		
		<view class="fixed padding flex justify-between align-center">
			<view class="">
				199
			</view>
			<button class="cu-btn bg-brown">立即支付</button>
		</view>
	</view>
</template>

<script>
	import {mapGetters} from 'vuex'
	export default {
		data() {
			return {
				
			}
		},
		computed: {
			...mapGetters({
				'orderAddress':'address/orderAddress'
			})
		},
		methods: {
			handleAddress(){
				uni.navigateTo({
					url:'../address/address'
				})
			}
		}
	}
</script>

<style>
.poster{
	width: 180upx;
	height: 180upx;
	background-color: #d8d8d8;
}
.info{
	width: 60%;
	.edit{
		width: 80upx;
		height: 80upx;
		text-align: center;
		line-height: 80upx;
		background-color: #e6e6e6;
		border-radius: 50%;
		
	}
}
.flex.align-end{
	min-width: 210upx;
}
.icon-gouxuan{
	color: #e7e7e7;
}
.cu-btn.lg{
	width: 50%;
}
</style>
