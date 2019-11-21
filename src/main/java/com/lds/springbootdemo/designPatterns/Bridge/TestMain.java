package com.lds.springbootdemo.designPatterns.Bridge;

/**
 * @program: springbootdemo
 * @description: 桥接模式测试类
 *
 * 当一种事物可在多种维度变化（如3个维度（m），每个维度3种可能(n)）时，如果为每一种可能创建一个子类，则每增加一个维度上的可能需要增加多个类，
 * 这会造成类爆炸（总共所需类：M的n次方）。并且非常多的重复功能。
 * 若使用桥接模式（总共所需类：m*n+n+1，使用类聚合，而非继承，将可缓解类爆炸，并增强可扩展性。
 *
 * 本测试中的桥接模式例子为把汽车拆成了三个维度，按品牌分（BMW、DF）、按挡位分（自动、手动）、按排量分（大、中、小）。这三个维度可以任意的进行组合。
 * 而我们如果要是想给某个维度增加一个可能的时候（比如挡位维度增加一个半自动），我们只需新建一个实现类（TransmissionSemiAuto）继承Transmission，
 * 其他的逻辑不用变就可实现。
 *
 * 个人理解：
 * 其实生活中的类似于组装的杂牌电脑，电脑的每一个模块（网卡、cpu、显卡、风扇等等）其实就是不同的维度。
 * 而我们在选择的时候，会有各种品牌或者型号的模块（网卡、cpu、显卡、风扇等等）。所以我们最终可以组装出很多种可能的电脑。
 * 如果要是新增一个维度的话就必须在桥接类中（本例的桥接类就是AbstractCar）设置一下相应的维度即可，最好是在设计之初就把所有的要拆分的维度分析清楚
 *
 * @author: lidongsheng
 * @createData: 2019-11-20 18:34
 * @updateAuthor: lidongsheng
 * @updateData: 2019-11-20 18:34
 * @updateContent:
 * @Version: 1.0.0
 * @email: lidongshenglife@163.com
 * @blog: www.b0c0.com
 * ************************************************
 * Copyright @ 李东升 2019. All rights reserved
 * ************************************************
 */

public class TestMain {
    public static void main(String[] args) {
        AbstractCar bmwCar=new CarBMW();
        bmwCar.setDisplacement(new DisplacementBig());
        bmwCar.setTransmission(new TransmissionAuto());
        bmwCar.run(5);
    }
}
