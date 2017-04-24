package com.sandy.designpattern.behavioral.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gondals on 24/08/16.
 */
public class MainClass {

    public static void main(String[] args) {
        System.out.println("Hello Command");
        Target target = new MyTarget();

        List<Command> commands = new ArrayList<>();
        commands.add(new NameSetterCommand());
        commands.add(new SalarySetterCommand());
        commands.add(new DetailPrinterCommand());

        commands.forEach( c -> c.execute(target));
    }

}
