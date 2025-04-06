package spring.designpatterns.dom.factory.user_generator.user_factory.auths;

import spring.designpatterns.dom.factory.user_generator.entity.Auth;

public class PrimitiveAuths implements Auths{
    @Override
    public Auth createAuth() {
        return new Auth("primitive");
    }
}
