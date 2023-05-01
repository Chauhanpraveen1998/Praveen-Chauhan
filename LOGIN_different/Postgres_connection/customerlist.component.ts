import { Component, OnInit } from '@angular/core';
import { DatabaseService } from '../database.service';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  customers: any[];

  constructor(private db: DatabaseService) { }

  async ngOnInit(): Promise<void> {
    this.customers = await this.db.query('SELECT * FROM customer');
  }
}
