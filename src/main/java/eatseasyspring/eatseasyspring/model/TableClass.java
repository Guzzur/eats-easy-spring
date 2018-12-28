package eatseasyspring.eatseasyspring.model;

import javax.persistence.*;

@Entity
@Table(name = "TablesData")
public class TableClass {
    @Id
    @SequenceGenerator(name="tables_table_id_gen", sequenceName="tables_table_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="tables_table_id_gen")
    @Column(name = "table_id")
    private int tableId;

    @Column(name = "table_code_name")
    private String tableCodeName;

    //@ManyToOne
    @JoinColumn(name = "rest_id")
    private int restId;

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public String getTableCodeName() {
        return tableCodeName;
    }

    public void setTableCodeName(String tableCodeName) {
        this.tableCodeName = tableCodeName;
    }

    public int getRestId() {
        return restId;
    }

    public void setRestId(int restId) {
        this.restId = restId;
    }
}

