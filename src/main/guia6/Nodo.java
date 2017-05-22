package main.guia6;

import main.guia6.interfaces.Node;

/**
 * Created by Tomas on 5/22/17.
 */
public class Nodo<T> implements Node<T> {

    private int row;
    private int column;
    private T value;

    public Nodo(int row, int column, T value) {
        this.row = row;
        this.column = column;
        this.value = value;
    }

    @Override
    public int getRow() {
        return row;
    }

    @Override
    public int getColumn() {
        return column;
    }

    @Override
    public T getValue() {
        return value;
    }
}
