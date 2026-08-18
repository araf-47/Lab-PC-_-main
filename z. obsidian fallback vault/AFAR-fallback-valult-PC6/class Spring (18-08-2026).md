
table 
`@ManyToOne(fetch = FetchType.EAGER)` < it also has fetch type `LAZY`

`@JoinColumn` < this one makes foreign key in table.


`@ManyToMany` is special. it creates a seperate table. 


=> Hibernate done (HQL). we can also do native query (SQL)
