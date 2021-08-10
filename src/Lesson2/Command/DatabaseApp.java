package Lesson2.Command;

public class DatabaseApp {
    public static void main(String[] args) {
        Database database = new Database();
        Developer dev = new Developer(new InsertCommand(database), new UpdateCommand(database),
                new SelectCommand(database), new DeleteCommand(database) );

        dev.insertCommand();
        dev.updateCommand();
        dev.selectCommand();
        dev.deleteCommand();
    }
}

class Database {
    void insert (){
        System.out.println("Inserting Record");
    }
    void update (){
        System.out.println("Updating Record");
    }
    void select (){
        System.out.println("Selecting Record");
    }
    void delete (){
        System.out.println("Deleting Record");
    }
}
interface CommandDatabase{
    void execute();
}

class InsertCommand implements CommandDatabase{
    Database database;

    public InsertCommand(Database database) {
        this.database = database;
    }

    @Override
    public void execute() {
        database.insert();
    }
}
class UpdateCommand implements CommandDatabase{
    Database database;

    public UpdateCommand(Database database) {
        this.database = database;
    }

    @Override
    public void execute() {
        database.update();
    }
}
class SelectCommand implements CommandDatabase{
    Database database;

    public SelectCommand(Database database) {
        this.database = database;
    }

    @Override
    public void execute() {
        database.select();
    }
}
class DeleteCommand implements CommandDatabase{
    Database database;

    public DeleteCommand(Database database) {
        this.database = database;
    }

    @Override
    public void execute() {
        database.delete();
    }
}

class Developer{
    CommandDatabase insert;
    CommandDatabase select;
    CommandDatabase update;
    CommandDatabase delete;

    public Developer(CommandDatabase insert, CommandDatabase select, CommandDatabase update, CommandDatabase delete) {
        this.insert = insert;
        this.select = select;
        this.update = update;
        this.delete = delete;
    }

    void insertCommand(){
        insert.execute();
    }
    void selectCommand(){
        select.execute();
    }
    void updateCommand(){
        update.execute();
    }
    void deleteCommand(){
        delete.execute();
    }

}